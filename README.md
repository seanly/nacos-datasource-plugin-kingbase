# 自定义人大金仓插件

### 1. 添加 人大金仓 插件

> 依赖已上传 maven 中央仓库，请勿使用阿里云代理

| NACOS 版本      | 插件版本     |
|---------------|----------|
| 2.4.0 - 2.4.1 | 0.0.5.PG |

```xml

<dependency>
    <groupId>com.alibaba.nacos.plugin</groupId>
    <artifactId>nacos-datasource-plugin-kingbase</artifactId>
    <version>0.0.5.PG</version>
</dependency>

<dependency>
  <groupId>cn.com.kingbase</groupId>
  <artifactId>kingbase8</artifactId>
  <version>9.0.0</version>
</dependency>
```

### 2. 导入 nacos 人大金仓 数据库脚本

- 请注意这里均使用 PG 协议测试，如有问题请自行修改脚本

- 特殊设置： kingbase.conf ， '' null 的转换

```shell
ora_input_emptystr_isnull = off
```

[点击下载 nacos kingbase 脚本](https://github.com/seanly/nacos-datasource-plugin-kingbase/tree/master/sql)

### 3. 配置 人大金仓 数据源链接信息

```yaml
db:
  num: 1
  url:
    0: jdbc:kingbase8://127.0.0.1:54321/test?currentSchema=pig_config
  user: SYSTEM
  password: SYSTEM
  pool:
    config:
      driver-class-name: com.kingbase8.Driver
```

### 4. 指定 nacos 数据源平台

```yaml
spring:
  datasource:
    platform: kingbase8
```
