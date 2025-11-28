@WebServlet("/save-robot")
public class SaveRobotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        String robotJson = request.getReader().lines()
            .collect(Collectors.joining(System.lineSeparator()));
        
        // Salvar no banco de dados ou arquivo
        try (FileWriter file = new FileWriter("robots/" + System.currentTimeMillis() + ".json")) {
            file.write(robotJson);
        }
        
        response.setStatus(HttpServletResponse.SC_OK);
    }
}