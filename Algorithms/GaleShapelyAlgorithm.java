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

        galeShapelyAlgorithm(men, women, menPreferences, womenPreferences);

    }

    private static void galeShapelyAlgorithm(List<String> men, List<String> women, Map<String,
            List<String>> menPreferences, Map<String, List<String>> womenPreferences) {

        List<String> unengagedMens = new ArrayList<>(menPreferences.keySet());
        Map<String, String> menPartner = new HashMap<>();
        Map<String, String> womenPartner = new HashMap<>();

        while(!unengagedMens.isEmpty()){
            String singleMen = unengagedMens.get(0);
            List<String> manChoice = menPreferences.get(singleMen);
            String woman = manChoice.get(0);
            System.out.println(womenPreferences);
            if(womenPartner.containsKey(woman)){
                List<String> pref = womenPreferences.get(woman);
                if(pref.indexOf(singleMen) < pref.indexOf(womenPartner.get(woman))){
                    unengagedMens.add(womenPartner.get(woman));
                    List<String> manPref = menPreferences.get(womenPartner.get(woman));
                    manPref.remove(woman);
                    menPreferences.put(womenPartner.get(woman), manPref);
                    womenPartner.put(woman, singleMen);
                    menPartner.put(singleMen, woman);
                    unengagedMens.remove(singleMen);
                }else{
                    manChoice.remove(woman);
                    menPreferences.put(singleMen, manChoice);
                }
            }else{
                menPartner.put(singleMen, woman);
                womenPartner.put(woman, singleMen);
                unengagedMens.remove(singleMen);
            }


        }

        System.out.println(menPartner);
    }

}
