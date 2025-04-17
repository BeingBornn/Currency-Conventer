# 💱 Currency Converter (Java Web Project)

A basic web-based currency converter built using **Java Servlets**, **HTML/CSS**, and **JavaScript**. It fetches live exchange rates and converts currencies dynamically without reloading the page.

---

## ✨ Features

- Convert between 150+ world currencies  
- Live exchange rates (via public currency API)  
- Fully functional frontend with HTML, CSS, and JavaScript  
- Java Servlet handles backend conversion logic  
- Clean JSON-based communication between frontend and backend  
- Deployed using Apache Tomcat  

---

## 🛠 Technologies Used

- Java (Servlets)  
- HTML & CSS  
- JavaScript (Fetch API)  
- [Fawaz Ahmed’s Free Exchange Rate API](https://github.com/fawazahmed0/currency-api)  
- Apache Tomcat  
- Eclipse IDE  

---

## 📁 Project Structure

```
CurrencyConverter/
├── src/
│   └── main/
│       └── java/
│           └── servlet/
│               └── currencyServlet.java
├── webapp/
│   ├── index.html
│   ├── script.js
│   ├── style.css
│   └── WEB-INF/
│       ├── lib/
│       │   └── json-20240303.jar
│       └── web.xml
```

---

## 🚀 How to Run

1. Import the project into Eclipse as a **Dynamic Web Project**  
2. Add the `json-20240303.jar` to `WEB-INF/lib`  
3. Configure Apache Tomcat in Eclipse  
4. Right-click project → `Run on Server`  
5. Open browser:  
 ```
 http://localhost:8082/CurrencyConverter/index.html
 ```
6. Enter an amount, choose currencies, and click **Convert**



