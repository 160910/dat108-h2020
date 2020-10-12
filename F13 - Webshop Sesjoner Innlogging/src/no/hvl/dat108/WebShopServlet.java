package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGOUT_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/" + WEBSHOP_URL)
public class WebShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Inn noe kode her i forbindelse med autorisasjon?
		//Inn noe kode her i forbindelse med uthenting av sesjonsdata?

		HttpSession sesjon = request.getSession(false);

		if (sesjon == null || sesjon.getAttribute("brukernavn") == null) {
			// ...
		} else {
			
			String brukernavn = (String) sesjon.getAttribute("brukernavn");
			Cart handlevogn = (Cart) sesjon.getAttribute("handlevogn");

			response.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Web Shop</title>");
			out.println("</head>");
			out.println("<body>");

			// Inn noe kode her for "Du er innlogget som <bruker>"?
			out.println("<p>Du er innlogget som " + brukernavn + "</p>");

			out.println("Din handlekurv:<br />");
			out.println("<table border=\"1\">");
			out.println("<tr><th>Vare</th><th>Pris</th></tr>");

			// Inn noe kode her for å vise innhold i handlevogn:
			 for (CartItem item : handlevogn.getItems()) {
				 out.println("<tr><td>" + item.getName() + "</td>"
						 + "<td align=\"right\">" + item.getPrice() + "</td></tr>");
			 }

			out.println("</table><br/>");
			out.println("<form action=\"" + WEBSHOP_URL + "\" method=\"post\">");
			out.println("<fieldset>");
			out.println("<legend>Handle</legend>");
			out.println("<input type=\"checkbox\" name=\"bukse\" />Bukse<br/>");
			out.println("<input type=\"checkbox\" name=\"genser\" />Genser<br/>");
			out.println("<p><input type=\"submit\" value=\"Legg i handlekurv\" /></p>");
			out.println("</fieldset>");
			out.println("</form>");
			out.println("<form action=\"" + LOGOUT_URL + "\" method=\"get\">");
			out.println("<fieldset>");
			out.println("<p><input type=\"submit\" value=\"Logg ut\" /></p>");
			out.println("</fieldset>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Inn noe kode her i forbindelse med autorisasjon?
		// Inn noe kode her i forbindelse med oppdatering av sesjonsdata?
		
		HttpSession sesjon = request.getSession(false);

		if (sesjon == null || sesjon.getAttribute("brukernavn") == null) {
			// ...
		} else {
			
			Cart handlevogn = (Cart) sesjon.getAttribute("handlevogn");
			
			//...
//				cart.addItem(new CartItem(???));
			
		
		}
		response.sendRedirect(WEBSHOP_URL);
	}
}











