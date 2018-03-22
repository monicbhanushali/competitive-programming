import java.io.*;
import java.util.*;

public class GaleShapelyAlgorithm {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(reader.readLine());

        List<String> men = new ArrayList<>();
        List<String> women = new ArrayList<>();
        Map<String, List<String>> menPreferences = new HashMap<>();
        Map<String, List<String>> womenPreferences = new HashMap<>();

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        while(st.hasMoreTokens()){
            men.add(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine(), " ");
        while(st.hasMoreTokens()){
            women.add(st.nextToken());
        }

        List<String> preference;
        for (int i = 0; i < N; i++) {
            preference = new ArrayList<>();
            st = new StringTokenizer(reader.readLine(), " ");
            while (st.hasMoreTokens()){
                preference.add(st.nextToken());
            }
            menPreferences.put(men.get(i), preference);
        }

        for (int i = 0; i < N; i++) {
            preference = new ArrayList<>();
            st = new StringTokenizer(reader.readLine(), " ");
            while (st.hasMoreTokens()){
                preference.add(st.nextToken());
            }
            womenPreferences.put(women.get(i), preference);
        }

        galeShapelyAlgorithm(menPreferences, womenPreferences);

    }

    private static void galeShapelyAlgorithm(Map<String,List<String>> menPreferences,
                                             Map<String, List<String>> womenPreferences) {

        List<String> unengagedMens = new ArrayList<>(menPreferences.keySet());
        Map<String, String> menPartner = new HashMap<>();
        Map<String, String> womenPartner = new HashMap<>();

        //Continue till all men are engaged
        while(!unengagedMens.isEmpty()){
            String singleMan = unengagedMens.get(0);
            List<String> hisPrefList = menPreferences.get(singleMan);
            String woman = hisPrefList.get(0);

            //Check is woman is already engaged.
            if(womenPartner.containsKey(woman)){
                List<String> herPrefList = womenPreferences.get(woman);
                //As woman is already engaged, we now check if she prefers the "proposing guy" over her current partner
                //If this guy appears before her current partner in preference list then we then woman accepts "proposing guy"
                if(herPrefList.indexOf(singleMan) < herPrefList.indexOf(womenPartner.get(woman))){
                    //making her current partner single :( and updating his preference list.
                    unengagedMens.add(womenPartner.get(woman));
                    List<String> currPartnerPrefList = menPreferences.get(womenPartner.get(woman));
                    currPartnerPrefList.remove(woman);
                    menPreferences.put(womenPartner.get(woman), currPartnerPrefList);
                    womenPartner.put(woman, singleMan);
                    menPartner.put(singleMan, woman);
                    unengagedMens.remove(singleMan);
                }else{
                    hisPrefList.remove(woman);
                    menPreferences.put(singleMan, hisPrefList);
                }
            }else{
                menPartner.put(singleMan, woman);
                womenPartner.put(woman, singleMan);
                unengagedMens.remove(singleMan);
            }
        }
        System.out.println(menPartner);
    }

}
