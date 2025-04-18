package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class currencyServlet
 */

public class currencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public currencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String amountStr = request.getParameter("amount");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			double amount = Double.parseDouble(amountStr);
			
			// Build API URL
			String apiURL = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/" + from + ".json";
			
			// Open the Connection to API
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder jsonBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonBuilder.append(line);
			}
			reader.close();
			
			// Parse JSON
			JSONObject obj = new JSONObject(jsonBuilder.toString());
			JSONObject rates = obj.getJSONObject(from);
			double rate = rates.getDouble(to);
			
			double result = amount * rate;
			JSONObject output = new JSONObject();
			output.put("result", String.format("%.2f", result));
			
			response.getWriter().write(output.toString());
			
		} catch (Exception e) {
		JSONObject error = new JSONObject();
		error.put("error", "conversion failed: " + e.getMessage());
		response.getWriter().write(error.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
