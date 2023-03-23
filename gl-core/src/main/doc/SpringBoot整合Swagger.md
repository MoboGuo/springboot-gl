1、pom文件

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>

2、创建swagger配置类，添加注解能够被扫描，swagger3.0已经不需要@EnableSwagger2注解

3、创建bean

    public Docket createRestApi() {
        //swagger3.0使用 OAS_30
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .select()
            //此包路径下的类，才生成接口文档
            .apis(RequestHandlerSelectors.basePackage("cn.opendatachain.manage.controller"))
            //加了ApiOperation的类,才生成接口文档  
            //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any())
            .build();
    }

设置API文档页面显示信息
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("文档标题")
            .description("文档描述")
            .contact(new Contact("作者", "作者地址", "作者邮箱"))
            .version("1.0")
            .build();
    }

5、升级swagger文档显示为knife4j只需要修该引依赖为

        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>3.0.3</version>
        </dependency>
    
然后在配置类上添加@EnableKnife4j即可开启swagger增强型knife4j，页面看着更方便

6、后续引入token后，可以在swagger上增加token的设置，在config文件下进行配置


swagger相关注解的使用，可参考实体类TSysuser，RedisTestController中的使用
* @Api：用在请求的类上，表示对类的说明
* tags="说明该类的作用，可以在UI界面上看到的注解"
* value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
* 
* @ApiOperation：用在请求的方法上，说明方法的用途、作用
* value="说明方法的用途、作用"
* notes="方法的备注说明"
* 
* @ApiImplicitParams：用在请求的方法上，表示一组参数说明
* 
* @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
* name：参数名
* value：参数的汉字说明、解释
* required：参数是否必须传
* paramType：参数放在哪个地方
* 
* header --> 请求参数的获取：@RequestHeader
* query --> 请求参数的获取：@RequestParam
* path（用于restful接口）--> 请求参数的获取：@PathVariable
* body（不常用）
* form（不常用）
* dataType：参数类型，默认String，其它值dataType="Integer"
* defaultValue：参数的默认值
* 
* @ApiResponses：用在请求的方法上，表示一组响应
* 
* @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
* code：数字，例如400
* message：信息，例如"请求参数没填好"
* response：抛出异常的类
* 
* @ApiModel：用于响应类上，表示一个返回响应数据的信息
* （这种一般用在post创建的时候，使用@RequestBody这样的场景， 请求参数无法使用@ApiImplicitParam注解进行描述的时候）
* 
* @ApiModelProperty：用在属性上，描述响应类的属性


使用例子可参考连接：https://blog.csdn.net/cristianoxm/article/details/128329539