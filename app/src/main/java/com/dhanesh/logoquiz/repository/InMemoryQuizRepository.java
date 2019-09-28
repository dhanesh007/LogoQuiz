package com.dhanesh.logoquiz.repository;

import com.dhanesh.logoquiz.data.QuizItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuizRepository implements IQuizRepository {

    private final String QUIZ_LIST = " [\n" +
                                     "  {\n" +
                                     "    \"imgUrl\": \"http://www.dsource.in/sites/default/files/resource/logo-design/logos/logos-representing-india/images/01.jpeg\",\n" +
                                     "    \"name\": \"AADHAAR\"\n" +
                                     "  },\n" +
                                     "  {\n" +
                                     "    \"imgUrl\": \"https://static.digit.in/default/thumb_101067_default_td_480x480.jpeg\",\n" +
                                     "    \"name\": \"PHONEPE\"\n" +
                                     "  },\n" +
                                     "  {\n" +
                                     "    \"imgUrl\": \"https://cdn.iconscout.com/icon/free/png-256/bhim-3-69845.png\",\n" +
                                     "    \"name\": \"BHIM\"\n" +
                                     "  },\n" +
                                     "  {\n" +
                                     "    \"imgUrl\": \"https://media.glassdoor.com/sqll/300494/flipkart-com-squarelogo-1433217726546.png\",\n" +
                                     "    \"name\": \"FLIPKART\"\n" +
                                     "  },\n" +
                                     "  {\n" +
                                     "    \"imgUrl\": \"http://logok.org/wp-content/uploads/2014/05/Walmart-Logo-880x645.png\",\n" +
                                     "    \"name\": \"WALMART\"\n" +
                                     "  },\n" +
                                     "  {\n" +
                                     "    \"imgUrl\": \"http://www.thestylesymphony.com/wp-content/uploads/2015/05/Myntra-logo.png\",\n" +
                                     "    \"name\": \"MYNTRA\"\n" +
                                     "  }\n" +
                                     "]";

    private List<QuizItem> mQuizItems;

    @Override
    public List<QuizItem> getQizItems() {
        if (mQuizItems == null) {
            mQuizItems = new ArrayList<>();

            try {
                JSONArray jsonArray = new JSONArray(QUIZ_LIST);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    mQuizItems.add(new QuizItem(jsonObject.getString("imageUrl"), jsonObject.getString("name")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return mQuizItems;
    }
}
