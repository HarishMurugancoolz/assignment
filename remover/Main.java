package remover;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static boolean namesMatch(String name)
    {
        String toremove="oggy";
        if(name.length()<4)
        {
            return false;
        }
        
        for(int i_name=0;i_name<4;i_name++)
        {
            if(name.charAt(i_name)!=toremove.charAt(i_name))
            {
                return false;
            }
        }
        return true;
        
    }
    public static void removeOggy(ArrayList<String> names) {
        for(int i_names=0;i_names<names.size();i_names++)
        {
                if(namesMatch(names[i_names]))
                {
                    names.remove(i_names);
                    i_names--;
                }
        }
        return;
    }
    public static boolean oggyIsRemoved(ArrayList<String> names) {
        List<String> oggys = names.stream().filter(it -> it.contains("oggy")).collect(Collectors.toList());
        return oggys.size() == 0;
    }
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("nobita", "bheem", "oggy", "oggy cockroach", "ninja"));
        removeOggy(names);
        if(oggyIsRemoved(names)) {
            System.out.println("Passed!");
            System.exit(0);
        } else {
            System.out.println("Failed!!");
            System.exit(1);
        }
    }
}
