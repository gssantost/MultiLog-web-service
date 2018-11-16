package com.utils;

import com.entities.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class LogParser {

    public JSONArray doArray(List<Log> logs) {
        JSONArray data = new JSONArray();
        for (Log _log : logs) {
            JSONObject obj = new JSONObject();
            obj.put("id", _log.getId())
                    .put("logType", _log.getLogType())
                    .put("description", _log.getDescription())
                    .put("module", _log.getModule())
                    .put("platform", _log.getPlatform())
                    .put("statusCode", _log.getCode());
            data.put(obj);
        }
        return data;
    }
}
