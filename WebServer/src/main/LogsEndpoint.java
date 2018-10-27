package main;

import com.Log;
import com.Logger;
import com.LoggerService;
import org.json.JSONObject;
import org.json.JSONString;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class LogsEndpoint extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        Logger service = new LoggerService().getLoggerPort();
        service.getLog("2018/10/22");
        out.print("Ping: " + service.ping());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        JSONObject body = new JSONObject(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        System.out.println(body.toString());

        Log log = new Log();
        log.setDescription(body.getString("description"));
        log.setLogType(body.getInt("logType"));
        log.setModule(body.getString("module"));
        log.setCode(body.getInt("statusCode"));
        log.setUrl("/here");
        log.setPlatform(1);

        JSONObject res = new JSONObject();
        Logger service = new LoggerService().getLoggerPort();
        if (service.add(log)) {
            res.put("status", 200).put("message", "LOG registered!");
        } else {
            res.put("status", 404).put("message", "Something happened while trying to register your LOG.");
        }
        out.print(res);
    }
}
