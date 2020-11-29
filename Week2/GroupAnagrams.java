package demo.leecode.medium;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * @Author zhouchao
 * @Date 2020/11/26 21:26
 * @Description https://leetcode-cn.com/problems/group-anagrams/ 49. 字母异位词分组
 **/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList();
                map.put(key, list);
            }
            list.add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strs);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(lists));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
