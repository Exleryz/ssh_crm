// 动态使用ajax加载数据字典，生成select
// 1. 数据字典类型
// 2. 将下拉选放入的标签id
// 3. 生成下拉选时name属性值
// 4. 需要回显时选中那个option
function loadSelcet(typecode, positionId, selectname, selectedId) {
    // 创建select对象，将name属性指定
    var $select = $("<select name=" + selectname + "></select>");
    // 添加提示选项
    $select.append($("<option value='' >---请选择---</option>"));
    // 使用jquery的ajax方法，访问后台action
    $.post("${pageContext.request.contextPath}/BaseDictAction", {dict_type_code:typecode}, function (data) {
        // 返回json数组对象遍历
        $.each(data, function (i, json) {
            // 每次遍历创建一个option对象，判断是否需要回显 并添加到select对象
            var $option = $("<option value= '"+ json['dict_id']+"'>" + json["dict_item_name"] + "</option>");
            if (json['dict_id'] == selectedId) {
                // 判断是否需要回显 需要使其被选中
                $option.attr("selected", "selected");
            }
            $select.append($option);
        });
    }, "json");
    // 将组装好的select对象放入页面指定位置
    $("#" + positionId).append($select);
}