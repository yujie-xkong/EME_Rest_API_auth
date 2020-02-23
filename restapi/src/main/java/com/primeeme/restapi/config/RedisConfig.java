package com.primeeme.restapi.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * Redis缓存配置类
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

  /**
   * 默认情况下，key值存在问题，当方法入参相同时，key值也相同，这样会造成不同的方法读取相同的缓存，从而造成异常
   * 修改后的key值为className+methodName+参数值列表，可以支持使用@Cacheable时不指定Key
   *
   * @return
   */
  @Bean
  public KeyGenerator keyGenerator() {
    return new KeyGenerator() {
      @Override
      public Object generate(Object o, Method method, Object... objects) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getClass().getName());
        sb.append(method.getName());
        for (Object obj : objects) {
          if (obj != null) {
            sb.append(obj.toString());
          }
        }
        return sb.toString();
      }
    };
  }

  /**
   * 配置CacheManager
   *
   * @param redisTemplate
   * @return
   */
  @Bean
  public CacheManager cacheManager(
      RedisTemplate<?, ?> redisTemplate) {
    // RedisCache需要一个RedisCacheWriter来实现读写Redis
    RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(redisTemplate.getConnectionFactory());
    // SerializationPair用于Java对象和Redis之间的序列化和反序列化
    // Spring Boot默认采用JdkSerializationRedisSerializer的二进制数据序列化方式
    // 使用该方式，保存在redis中的值是人类无法阅读的乱码，并且该Serializer要求目标类必须实现Serializable接口
    // 使用StringRedisSerializer来序列化和反序列化redis的key值
    RedisSerializationContext.SerializationPair keySerializationPair = RedisSerializationContext.SerializationPair
        .fromSerializer(new StringRedisSerializer());
    // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    RedisSerializationContext.SerializationPair valueSerializationPair = RedisSerializationContext.SerializationPair
        .fromSerializer(jackson2JsonRedisSerializer);
    // 构造一个RedisCache的配置对象，设置缓存过期时间和Key、Value的序列化机制
    // 这里设置缓存过期时间为7天
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(7))
        .serializeKeysWith(keySerializationPair).serializeValuesWith(valueSerializationPair);
    return new RedisCacheManager(writer, config);
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate redisTemplate = new RedisTemplate();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    //定义key序列化方式
    RedisSerializer<String> redisSerializer = new StringRedisSerializer();
    //定义value的序列化方式
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    redisTemplate.setKeySerializer(redisSerializer);
    redisTemplate.setHashKeySerializer(redisSerializer);
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }
}





