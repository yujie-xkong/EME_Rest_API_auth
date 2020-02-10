package com.primeeme.restapi;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
// 切换为 freemarker 模板引擎
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath + "/src/main/java");
    gc.setAuthor("eugene");
    gc.setOpen(false);
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    //       dsc.setUrl("jdbc:mysql://portal-xmb.mysql.rds.aliyuncs.com:3306/dabdb?useUnicode=true&useSSL=false&characterEncoding=utf8");
    dsc.setUrl("jdbc:sqlserver://pgseme-migration.database.windows.net:1433;database=eme-migration;user=pgseme-migration@pgseme-migration;password=U7rosd1A*KXsnyddo7Uq;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    dsc.setUsername("pgseme-migration");
    dsc.setPassword("U7rosd1A*KXsnyddo7Uq");
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
    pc.setParent("com.primeeme.restapi");
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名
        return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
      }
    });

    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController();

    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//        strategy.setInclude(scanner("表名"));
    strategy.setInclude("mz_fc_request_record");
//        strategy.setSuperEntityColumns("id");
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix(pc.getModuleName() + "_");
    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }

}