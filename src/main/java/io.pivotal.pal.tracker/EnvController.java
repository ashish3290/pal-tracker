package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    @Value("${PORT:NOT SET}")
    private String PORT;
    @Value("${MEMORY_LIMIT:NOT SET}")
    private String MEMORY_LIMIT;
    @Value("${CF_INSTANCE_INDEX:NOT SET}")
    private String CF_INSTANCE_INDEX;
    @Value("${CF_INSTANCE_ADDR:NOT SET}")
      private String  CF_INSTANCE_ADDR;

    public EnvController() {
    }

    public EnvController(String PORT, String MEMORY_LIMIT, String CF_INSTANCE_INDEX, String CF_INSTANCE_ADDR) {
        this.PORT = PORT;
        this.MEMORY_LIMIT = MEMORY_LIMIT;
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
    }

    @GetMapping("/env")
    public Map<String,String> getEnv()
    {
      Map<String,String> map=new HashMap<>();
        map.put("PORT",PORT);
        map.put("MEMORY_LIMIT",MEMORY_LIMIT);
        map.put("CF_INSTANCE_INDEX",CF_INSTANCE_INDEX);
        map.put("CF_INSTANCE_ADDR",CF_INSTANCE_ADDR);
        return map;
    }

}
