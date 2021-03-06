<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑菜单</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/css/base.css">
</head>
<body>
<div class="content-body">
    <form class="layui-form" action="">
        <input type="hidden" name="id" value="${menu.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">上级菜单</label>
            <div class="layui-input-block">
                <select name="parentId">
                    <option value="0">请选择</option>
                    <c:forEach items="${menus}" var="menuItem">
                        <option value="${menuItem.id}"
                                <c:if test="${menuItem.id == menu.parentId}">selected</c:if>>${menuItem.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入菜单名称" autocomplete="off"
                       class="layui-input" value="${menu.name}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="url" placeholder="链接地址" autocomplete="off" class="layui-input"
                       value="${menu.url}">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">图标</label>
            <div class="layui-input-block">
                <input type="text" name="icon" placeholder="图标" autocomplete="off" class="layui-input"
                       value="${menu.icon}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">排序号</label>
            <div class="layui-input-block">
                <input type="text" name="orderNo"  placeholder="排序号" autocomplete="off" class="layui-input"  value="${menu.orderNo}">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>
</div>

<script src="/layui/layui.js"></script>
<script>
    layui.use(['form', 'jquery'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(formDemo)', function (data) {
            $.post("/admin/menu/updateMenu", data.field, function (data) {
                if (data.code === 0) {
                    parent.layer.closeAll();
                    layer.msg('创建成功', {icon: 1});
                } else {
                    layer.alert(data.msg, {icon: 5});
                }
            }, "json");
            return false;
        });
    });
</script>
</body>
</html>
