
layui.use(['layer', 'form'], function () {
    var layer = layui.layer;
    var form = layui.form;
    var $ = layui.jquery;

    $("#loginButton").on('click',function (){
        var userName = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "post",
            url: '/api/login/login',
            data: {
                userName:userName,
                password:password
            },
            success: function (data) {
                console.log(data);
                layer.msg(data.msg);
            }
        });
    });
    $("#checkLogin").on('click',function (){
        $.ajax({
            type: "post",
            url: '/api/login/isLogin',
            success: function (data) {
                console.log(data);
                layer.msg(data.msg);
            }
        });
    });

});