<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>客户列表</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <SCRIPT language=javascript>
        function changePage(pageNum) {
            // 1. 获得表单
            // 2. 将页码的值放入对应表单隐藏域中
            $("#currentPageInput").val(pageNum);
            // 3. 提交表单
            $("#pageForm").submit();
        };

        function changePageSize(pageSize) {
            $("#pageSizeInput").val(pageSize);    // 注意此处jquery自动提示大小写问题
            $("#pageForm").submit();
        }

        function selectCustomer(cust_id, cust_name) {
            var win = window.opener;    // 获得添加页面的window对象
            // 获得添加页面的document对象
            var doc = win.document;
            // 获得隐藏域和文本框，并赋值
            doc.getElementById("cust_id").value = cust_id;
            doc.getElementById("cust_name").value = cust_name;
            // 关闭当前窗口
            window.close();
        }
    </SCRIPT>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
                          border=0></TD>
        <TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
            height=20></TD>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
                          border=0></TD>
    </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
                src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
        <TD vAlign=top width="100%" bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                <TR>
                    <TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
                </TR>
                <TR>
                    <TD height=2></TD>
                </TR>
            </TABLE>
            <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
                   width="100%" align=center border=0>
                <TBODY>
                <TR>
                    <TD>
                        <TABLE id=grid
                               style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
                               cellSpacing=1 cellPadding=2 rules=all border=0>
                            <TBODY>
                            <TR
                                    style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                <TD>行业名称</TD>
                                <TD>统计数量</TD>
                            </TR>

                            <s:iterator value="#list" var="arr">
                                <TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                    <TD><s:property value="#arr[0]"></s:property></TD>
                                    <TD><s:property value="#arr[1]"></s:property></TD>
                            </s:iterator>
                            </TBODY>
                        </TABLE>
                    </TD>
                </TR>
                </TBODY>
            </TABLE>
        </TD>
        <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
                src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
    </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
                          border=0></TD>
        <TD align=middle width="100%"
            background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
        <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
                          border=0></TD>
    </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
