package org.choongang.global.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 사이트 설정 로드 및 조회
 * resource 폴더에 있는 설정 파일 가져오기
 */
public class AppConfig {
    private final static ResourceBundle bundle;
    private final static Map<String, String> configs;
    static {
        // 환경 변수 mode에 따라 설정파일을 분리 예) prod이면 application-prod.properties로 읽어온다.
        String mode = System.getenv("mode");
        mode = mode == null || mode.isBlank() ? "":"-" + mode;

        bundle = ResourceBundle.getBundle("application" + mode); //해당 모드의 application 파일 로드
        configs = new HashMap<>();
        Iterator<String> iter = bundle.getKeys().asIterator();
        while(iter.hasNext()) {
            String key = iter.next();
            String value = bundle.getString(key);
            configs.put(key, value);
        }
    }

    public static String get(String key) {
        return configs.get(key);
    }
}