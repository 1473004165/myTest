# sanquanguan

## 如何使用

01. 导入/sql/sanquan.sql文件

02. 修改/src/main/resources/application-test.yml 内 13、15、17行mysql数据源为本机数据源

03.  修改/src/main/resources/application-test.yml 内 80、81、82行redis数据源为本机数据源

ps：后续使用云服务器后无需以上步骤

## sql监控地址
http://127.0.0.1:10086/druid/index.html

## 在线文档地址
http://127.0.0.1:10086/swagger-ui.html

## 开发注意事项

1. 每次更新代码部分必须打备注，有冲突的手动合并冲突后再进行提交
2. 项目的配置文件不能自行做修改
3. 编码规范参照《阿里巴巴java开发手册》；可以再idea中下载该插件
4. 其他事项会在开发的过程中持续更新

