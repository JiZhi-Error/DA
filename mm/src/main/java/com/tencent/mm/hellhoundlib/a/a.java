package com.tencent.mm.hellhoundlib.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private static final Map<String, d> hlK = new HashMap();

    static {
        AppMethodBeat.i(55540);
        AppMethodBeat.o(55540);
    }

    public static void g(Map<String, List<Pair<String, String>>> map, c cVar) {
        AppMethodBeat.i(55532);
        if (map == null || map.isEmpty() || cVar == null) {
            AppMethodBeat.o(55532);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, List<Pair<String, String>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Pair<String, String>> value = entry.getValue();
                    if (value != null) {
                        for (Pair<String, String> pair : value) {
                            String str = key + "|" + ((String) pair.first) + "|" + ((String) pair.second);
                            if (hlK.containsKey(str)) {
                                d dVar = hlK.get(str);
                                if (dVar == null) {
                                    dVar = new d();
                                }
                                if (!dVar.listeners.contains(cVar)) {
                                    dVar.listeners.add(cVar);
                                    hlK.put(str, dVar);
                                }
                            } else {
                                d dVar2 = new d();
                                dVar2.listeners.add(cVar);
                                hlK.put(str, dVar2);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(55532);
            }
        }
    }

    public static void h(Map<String, List<Pair<String, String>>> map, c cVar) {
        AppMethodBeat.i(177068);
        if (map == null || cVar == null) {
            AppMethodBeat.o(177068);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, List<Pair<String, String>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Pair<String, String>> value = entry.getValue();
                    if (value != null) {
                        for (Pair<String, String> pair : value) {
                            String str = key + "|" + ((String) pair.first) + "|" + ((String) pair.second);
                            d dVar = hlK.get(str);
                            if (dVar != null && dVar.listeners != null && !dVar.listeners.isEmpty() && dVar.listeners.contains(cVar)) {
                                dVar.listeners.remove(cVar);
                                if (dVar.listeners.isEmpty() && dVar.hlL.isEmpty()) {
                                    hlK.remove(str);
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(177068);
            }
        }
    }

    public static void i(Map<String, Pair<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(168722);
        if (map == null || map.isEmpty() || cVar == null) {
            AppMethodBeat.o(168722);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, Pair<String, List<Pair<String, String>>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Pair<String, List<Pair<String, String>>> value = entry.getValue();
                    if (value != null) {
                        for (Pair pair : (List) value.second) {
                            String str = key + ((String) value.first) + "|" + ((String) pair.first) + "|" + ((String) pair.second);
                            if (hlK.containsKey(str)) {
                                d dVar = hlK.get(str);
                                if (dVar == null) {
                                    dVar = new d();
                                }
                                if (!dVar.listeners.contains(cVar)) {
                                    dVar.listeners.add(cVar);
                                    hlK.put(str, dVar);
                                }
                            } else {
                                d dVar2 = new d();
                                dVar2.listeners.add(cVar);
                                hlK.put(str, dVar2);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(168722);
            }
        }
    }

    public static void j(Map<String, Pair<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(177069);
        if (map == null) {
            AppMethodBeat.o(177069);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, Pair<String, List<Pair<String, String>>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Pair<String, List<Pair<String, String>>> value = entry.getValue();
                    if (value != null) {
                        for (Pair pair : (List) value.second) {
                            String str = key + ((String) value.first) + "|" + ((String) pair.first) + "|" + ((String) pair.second);
                            d dVar = hlK.get(str);
                            if (dVar != null && dVar.listeners != null && !dVar.listeners.isEmpty() && dVar.listeners.contains(cVar)) {
                                dVar.listeners.remove(cVar);
                                if (dVar.listeners.isEmpty() && dVar.hlL.isEmpty()) {
                                    hlK.remove(str);
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(177069);
            }
        }
    }

    public static void k(Map<String, Map<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(177070);
        if (map == null || map.isEmpty() || cVar == null) {
            AppMethodBeat.o(177070);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, Map<String, List<Pair<String, String>>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Map<String, List<Pair<String, String>>> value = entry.getValue();
                    if (value != null) {
                        for (Map.Entry<String, List<Pair<String, String>>> entry2 : value.entrySet()) {
                            String key2 = entry2.getKey();
                            for (Pair<String, String> pair : entry2.getValue()) {
                                String str = key + key2 + "|" + ((String) pair.first) + "|" + ((String) pair.second);
                                if (hlK.containsKey(str)) {
                                    d dVar = hlK.get(str);
                                    if (dVar == null) {
                                        dVar = new d();
                                    }
                                    if (!dVar.listeners.contains(cVar)) {
                                        dVar.listeners.add(cVar);
                                        hlK.put(str, dVar);
                                    }
                                } else {
                                    d dVar2 = new d();
                                    dVar2.listeners.add(cVar);
                                    hlK.put(str, dVar2);
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(177070);
            }
        }
    }

    public static void l(Map<String, Map<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(177071);
        if (map == null) {
            AppMethodBeat.o(177071);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, Map<String, List<Pair<String, String>>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Map<String, List<Pair<String, String>>> value = entry.getValue();
                    if (value != null) {
                        for (Map.Entry<String, List<Pair<String, String>>> entry2 : value.entrySet()) {
                            String key2 = entry2.getKey();
                            for (Pair<String, String> pair : entry2.getValue()) {
                                String str = key + key2 + "|" + ((String) pair.first) + "|" + ((String) pair.second);
                                d dVar = hlK.get(str);
                                if (dVar != null && dVar.listeners != null && !dVar.listeners.isEmpty() && dVar.listeners.contains(cVar)) {
                                    dVar.listeners.remove(cVar);
                                    if (dVar.listeners.isEmpty() && dVar.hlL.isEmpty()) {
                                        hlK.remove(str);
                                    }
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(177071);
            }
        }
    }

    public static void c(List<Pair<String, String>> list, b bVar) {
        AppMethodBeat.i(177072);
        if (list == null || list.isEmpty() || bVar == null) {
            AppMethodBeat.o(177072);
            return;
        }
        synchronized (hlK) {
            try {
                for (Pair<String, String> pair : list) {
                    String str = "Undefined|" + ((String) pair.first) + "|" + ((String) pair.second);
                    if (hlK.containsKey(str)) {
                        d dVar = hlK.get(str);
                        if (dVar == null) {
                            dVar = new d();
                        }
                        if (!dVar.hlL.contains(bVar)) {
                            dVar.hlL.add(bVar);
                            hlK.put(str, dVar);
                        }
                    } else {
                        d dVar2 = new d();
                        dVar2.hlL.add(bVar);
                        hlK.put(str, dVar2);
                    }
                }
            } finally {
                AppMethodBeat.o(177072);
            }
        }
    }

    public static void d(List<Pair<String, String>> list, b bVar) {
        AppMethodBeat.i(183787);
        if (list == null || list.isEmpty() || bVar == null) {
            AppMethodBeat.o(183787);
            return;
        }
        synchronized (hlK) {
            try {
                for (Pair<String, String> pair : list) {
                    String str = "Undefined|" + ((String) pair.first) + "|" + ((String) pair.second);
                    d dVar = hlK.get(str);
                    if (dVar != null && dVar.hlL != null && !dVar.hlL.isEmpty() && dVar.hlL.contains(bVar)) {
                        dVar.hlL.remove(bVar);
                        if (dVar.hlL.isEmpty() && dVar.listeners.isEmpty()) {
                            hlK.remove(str);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(183787);
            }
        }
    }

    public static void c(Map<String, List<Pair<String, String>>> map, b bVar) {
        AppMethodBeat.i(183788);
        if (map == null || map.isEmpty() || bVar == null) {
            AppMethodBeat.o(183788);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, List<Pair<String, String>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Pair<String, String>> value = entry.getValue();
                    if (value != null) {
                        for (Pair<String, String> pair : value) {
                            String str = key + "_EXEC_|" + ((String) pair.first) + "|" + ((String) pair.second);
                            if (hlK.containsKey(str)) {
                                d dVar = hlK.get(str);
                                if (dVar == null) {
                                    dVar = new d();
                                }
                                if (!dVar.hlL.contains(bVar)) {
                                    dVar.hlL.add(bVar);
                                    hlK.put(str, dVar);
                                }
                            } else {
                                d dVar2 = new d();
                                dVar2.hlL.add(bVar);
                                hlK.put(str, dVar2);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(183788);
            }
        }
    }

    public static void d(Map<String, List<Pair<String, String>>> map, b bVar) {
        AppMethodBeat.i(183789);
        if (map == null || bVar == null) {
            AppMethodBeat.o(183789);
            return;
        }
        synchronized (hlK) {
            try {
                for (Map.Entry<String, List<Pair<String, String>>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Pair<String, String>> value = entry.getValue();
                    if (value != null) {
                        for (Pair<String, String> pair : value) {
                            String str = key + "_EXEC_|" + ((String) pair.first) + "|" + ((String) pair.second);
                            d dVar = hlK.get(str);
                            if (dVar != null && dVar.hlL != null && !dVar.hlL.isEmpty() && dVar.hlL.contains(bVar)) {
                                dVar.hlL.remove(bVar);
                                if (dVar.hlL.isEmpty() && dVar.listeners.isEmpty()) {
                                    hlK.remove(str);
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(183789);
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
        AppMethodBeat.i(183790);
        String str5 = str2 + "|" + str3 + "|" + str4;
        synchronized (hlK) {
            try {
                d dVar = hlK.get(str5);
                if (!(dVar == null || dVar.listeners == null || dVar.listeners.isEmpty())) {
                    for (c cVar : dVar.listeners) {
                        if (cVar != null) {
                            cVar.a(str, str3, str4, obj, objArr);
                        }
                    }
                    AppMethodBeat.o(183790);
                }
            } finally {
                AppMethodBeat.o(183790);
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, Object obj, Object obj2) {
        AppMethodBeat.i(186280);
        String str5 = str2 + "|" + str3 + "|" + str4;
        synchronized (hlK) {
            try {
                d dVar = hlK.get(str5);
                if (!(dVar == null || dVar.listeners == null || dVar.listeners.isEmpty())) {
                    for (c cVar : dVar.listeners) {
                        if (cVar != null) {
                            cVar.a(str, str3, str4, obj, obj2);
                        }
                    }
                    AppMethodBeat.o(186280);
                }
            } finally {
                AppMethodBeat.o(186280);
            }
        }
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, Object obj, Object[] objArr) {
        AppMethodBeat.i(186281);
        String str7 = str4 + "|" + str5 + "|" + str6;
        synchronized (hlK) {
            try {
                d dVar = hlK.get(str7);
                if (!(dVar == null || dVar.hlL == null || dVar.hlL.isEmpty())) {
                    for (b bVar : dVar.hlL) {
                        if (bVar != null) {
                            bVar.c(str, str2, str3, str5, obj, objArr);
                        }
                    }
                    AppMethodBeat.o(186281);
                }
            } finally {
                AppMethodBeat.o(186281);
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, Object obj) {
        AppMethodBeat.i(186282);
        String str5 = str2 + "|" + str3 + "|" + str4;
        synchronized (hlK) {
            try {
                d dVar = hlK.get(str5);
                if (!(dVar == null || dVar.hlL == null || dVar.hlL.isEmpty())) {
                    for (b bVar : dVar.hlL) {
                        if (bVar != null) {
                            bVar.a(str, str3, str4, obj);
                        }
                    }
                    AppMethodBeat.o(186282);
                }
            } finally {
                AppMethodBeat.o(186282);
            }
        }
    }

    public static void b(String str, String str2, String str3, String str4, Object obj) {
        AppMethodBeat.i(177075);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, (String) null, (String) null, str2, str3, str4, obj, (Object[]) null);
        AppMethodBeat.o(177075);
    }

    public static void b(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
        AppMethodBeat.i(177076);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, (String) null, (String) null, str2, str3, str4, obj, objArr);
        AppMethodBeat.o(177076);
    }

    public static void a(Object obj, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(183792);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, (String) null, (String) null, str2, str3, str4, obj, (Object) null);
        AppMethodBeat.o(183792);
    }

    public static void a(boolean z, Object obj, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(186283);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, (String) null, (String) null, str2, str3, str4, obj, Boolean.valueOf(z));
        AppMethodBeat.o(186283);
    }

    public static void a(Object obj, Object[] objArr, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(177077);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, str2, str3, str4, str5, str6, obj, objArr);
        AppMethodBeat.o(177077);
    }

    public static void a(Object obj, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(183794);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, str2, str3, str4, str5, str6, obj, (Object) null);
        AppMethodBeat.o(183794);
    }

    public static boolean a(Object obj, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(186284);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(str, str2, str3, str4, str5, str6, obj, Boolean.valueOf(z));
        AppMethodBeat.o(186284);
        return z;
    }
}
