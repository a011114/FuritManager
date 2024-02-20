package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Furit;
import service.FuritService;
import service.FuritServiceImpl;



@WebServlet("/FuritServlet")
public class FuritServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		switch (type) {
		case "showAll":
			showAll(request,response);
			break;
		case "toUpdate":
			toUpdate(request,response);
			break;
		case "add":
			add(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showAll(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		FuritService furitService = new FuritServiceImpl();
		List<Furit> glist = furitService.showAll();
		
		request.setAttribute("glist", glist);
		request.getRequestDispatcher("goodsManage.jsp").forward(request, response);
	}

	private void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		long gid = Long.parseLong(request.getParameter("gid"));
		
		
		FuritService goodsService = new FuritServiceImpl();
		Furit goods = goodsService.showDetail(gid);
		System.out.println("goods in toUpdate():"+goods);
	
		
		
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("goodsUpdate.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gid = request.getParameter("gid");
		String gname = request.getParameter("gname");
		String gunit = request.getParameter("gunit");
		String gprice = request.getParameter("gprice");
		String grem = request.getParameter("grem");
		Furit goods = new Furit();
		goods.setGid(Long.parseLong(gid));
		goods.setGname(gname);
		goods.setUnit(gunit);
		goods.setPrice(Double.parseDouble(gprice));
		goods.setRemain(Float.parseFloat(grem));
		FuritService goodsService = new FuritServiceImpl();
		String info = goodsService.add(goods);
		if("success".equals(info)) {
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("refresh", "0;URL=FuritServlet?type=showAll");
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
			response.getWriter().println("商品添加失败，请重试！");
			response.getWriter().print("</body>");
			response.setHeader("refresh", "2;URL=goodsAdd.jsp");
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String gid = request.getParameter("gid");
		String gname = request.getParameter("gname");
		String gunit = request.getParameter("gunit");
		String gprice = request.getParameter("gprice");
		String grem = request.getParameter("grem");
		
		
		Furit goods = new Furit();
		goods.setGid(Long.parseLong(gid));
		goods.setGname(gname);
		goods.setUnit(gunit);
		goods.setPrice(Double.parseDouble(gprice));
		goods.setRemain(Float.parseFloat(grem));
		
		
		FuritService goodsService = new FuritServiceImpl();
		String info = goodsService.update(goods);

		if("success".equals(info)) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
			response.getWriter().print("商品修改成功");
			response.getWriter().print("</body>");
			response.setHeader("refresh", "1;URL=FuritServlet?type=showAll");
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
			response.getWriter().println("商品修改失败，请重试！");
			response.getWriter().print("</body>");
			response.setHeader("refresh", "2;URL=FuritServlet?type=showAll");
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");// 设置请求的编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		long gid = Long.parseLong(request.getParameter("gid"));
		
		
		FuritService goodsService = new FuritServiceImpl();
		String info = goodsService.delete(gid);
		
		
		response.setContentType("text/html;charset=utf-8");
		out.print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
		out.println(info);
		out.print("</body>");
		response.setHeader("refresh", "2;URL=FuritServlet?type=showAll");
	}
}
