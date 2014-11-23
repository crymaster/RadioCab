<%@page import="java.nio.file.Path"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<jsp:include page="header.jsp"></jsp:include>
    <div class="wrapper row-offcanvas row-offcanvas-left">
        <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">                
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <%
                        String uri = request.getRequestURI();

String pageName = uri.substring(uri.lastIndexOf("/")+1);
                        String str=pageName+"?";
Enumeration<String> paramNames = request.getParameterNames();
while (paramNames.hasMoreElements())
{
    String paramName = paramNames.nextElement();
    String[] paramValues = request.getParameterValues(paramName);
    for (int i = 0; i < paramValues.length; i++) 
    {
        String paramValue = paramValues[i];
        str=str + paramName + "=" + paramValue;
    }
    str=str+"&";
}

                        String fullURI = str.substring(0,str.length()-1);
                    %>
                    
                    <%
                        File webappFileSystemPath = new File(request.getSession().getServletContext().getRealPath("/"));  
                        
                        Path path = webappFileSystemPath.toPath();
                        path.getParent().getParent();
                        out.println(path.getParent().getParent().toString());
                    %>
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">404</li>
                </ol>
            </section>

            <!-- Main content -->
                <section class="content">

                    <div class="error-page">
                        <h2 class="headline text-info"> 404</h2>
                        <div class="error-content">
                            <h3><i class="fa fa-warning text-yellow"></i> Oops! Page not found.</h3>
                            <p>
                                We could not find the page you were looking for.
                                Meanwhile, you may <a href='../../index.html'>return to dashboard</a> or try using the search form.
                            </p>
                            <form class='search-form'>
                                <div class='input-group'>
                                    <input type="text" name="search" class='form-control' placeholder="Search"/>
                                    <div class="input-group-btn">
                                        <button type="submit" name="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
                                    </div>
                                </div><!-- /.input-group -->
                            </form>
                        </div><!-- /.error-content -->
                    </div><!-- /.error-page -->

                </section><!-- /.content -->
        </aside><!-- /.right-side -->
    </div><!-- ./wrapper -->


<jsp:include page="footer.jsp"></jsp:include>