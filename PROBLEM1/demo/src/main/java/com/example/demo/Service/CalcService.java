package com.example.demo.Service;

import com.example.demo.Config.AppConfig;
import com.example.demo.Util.NumberFetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalcService {

    @Autowired
    private AppConfig config;

    @Autowired
    private NumberFetch numberFetch;

    private final Map<String, LinkedList<Integer>> numberWindows = new HashMap<>();

    public Map<String, Object> getNumbers(String qualifier) {
        if (!isValidQualifier(qualifier)) {
            return Map.of("error", "Invalid number ID");
        }

        List<Integer> newNumbers = numberFetch.fetchNumbers(qualifier);
        LinkedList<Integer> currentWindow = numberWindows.getOrDefault(qualifier, new LinkedList<>());

        Set<Integer> uniqueNumbers = new LinkedHashSet<>(currentWindow);
        uniqueNumbers.addAll(newNumbers);
        List<Integer> updatedWindow = new ArrayList<>(uniqueNumbers);

        if (updatedWindow.size() > config.getWindowSize()) {
            updatedWindow = updatedWindow.subList(updatedWindow.size() - config.getWindowSize(), updatedWindow.size());
        }

        numberWindows.put(qualifier, new LinkedList<>(updatedWindow));

        double average = updatedWindow.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        Map<String, Object> response = new HashMap<>();
        response.put("numbers", newNumbers);
        response.put("windowPrevState", new LinkedList<>(currentWindow));
        response.put("windowCurrState", updatedWindow);
        response.put("avg", Math.round(average * 100.0) / 100.0);

        return response;
    }

    public boolean isValidQualifier(String qualifier) {
        return Arrays.asList("p", "f", "e", "r").contains(qualifier);
    }
}
