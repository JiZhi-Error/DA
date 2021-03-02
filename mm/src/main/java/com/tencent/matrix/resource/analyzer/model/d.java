package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d implements Serializable {
    public final Map<String, Map<String, e>> cXN;
    public final Map<String, Map<String, e>> cXO;
    public final Map<String, e> cXP;
    public final Map<String, e> cXQ;

    public interface a {
        b L(String str, String str2);

        b M(String str, String str2);

        d SY();

        b eL(String str);

        b eM(String str);
    }

    d(b bVar) {
        this.cXN = n(bVar.cXN);
        this.cXO = n(bVar.cXO);
        this.cXP = o(bVar.cXP);
        this.cXQ = o(bVar.cXQ);
    }

    private static Map<String, Map<String, e>> n(Map<String, Map<String, c>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Map<String, c>> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), o(entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Map<String, e> o(Map<String, c> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, c> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), new e(entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public final String toString() {
        String str = "";
        for (Map.Entry<String, Map<String, e>> entry : this.cXN.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<String, e> entry2 : entry.getValue().entrySet()) {
                str = str + "| Field: " + key + "." + entry2.getKey() + (entry2.getValue().cXT ? " (always)" : "") + "\n";
            }
        }
        for (Map.Entry<String, Map<String, e>> entry3 : this.cXO.entrySet()) {
            String key2 = entry3.getKey();
            for (Map.Entry<String, e> entry4 : entry3.getValue().entrySet()) {
                str = str + "| Static field: " + key2 + "." + entry4.getKey() + (entry4.getValue().cXT ? " (always)" : "") + "\n";
            }
        }
        for (Map.Entry<String, e> entry5 : this.cXP.entrySet()) {
            str = str + "| Thread:" + entry5.getKey() + (entry5.getValue().cXT ? " (always)" : "") + "\n";
        }
        for (Map.Entry<String, e> entry6 : this.cXQ.entrySet()) {
            str = str + "| Class:" + entry6.getKey() + (entry6.getValue().cXT ? " (always)" : "") + "\n";
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        String cXS;
        boolean cXT;
        final String cXU;
        String name;

        c(String str) {
            this.cXU = str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements a {
        final Map<String, Map<String, c>> cXN = new LinkedHashMap();
        final Map<String, Map<String, c>> cXO = new LinkedHashMap();
        final Map<String, c> cXP = new LinkedHashMap();
        final Map<String, c> cXQ = new LinkedHashMap();
        private c cXR;

        b() {
        }

        @Override // com.tencent.matrix.resource.analyzer.model.d.a
        public final b L(String str, String str2) {
            com.tencent.matrix.resource.analyzer.a.b.checkNotNull(str, "mClassName");
            com.tencent.matrix.resource.analyzer.a.b.checkNotNull(str2, "fieldName");
            Map<String, c> map = this.cXN.get(str);
            if (map == null) {
                map = new LinkedHashMap<>();
                this.cXN.put(str, map);
            }
            this.cXR = new c("field " + str + "#" + str2);
            map.put(str2, this.cXR);
            return this;
        }

        @Override // com.tencent.matrix.resource.analyzer.model.d.a
        public final b M(String str, String str2) {
            com.tencent.matrix.resource.analyzer.a.b.checkNotNull(str, "mClassName");
            com.tencent.matrix.resource.analyzer.a.b.checkNotNull(str2, "fieldName");
            Map<String, c> map = this.cXO.get(str);
            if (map == null) {
                map = new LinkedHashMap<>();
                this.cXO.put(str, map);
            }
            this.cXR = new c("static field " + str + "#" + str2);
            map.put(str2, this.cXR);
            return this;
        }

        @Override // com.tencent.matrix.resource.analyzer.model.d.a
        public final b eL(String str) {
            com.tencent.matrix.resource.analyzer.a.b.checkNotNull(str, "threadName");
            this.cXR = new c("any threads named ".concat(String.valueOf(str)));
            this.cXP.put(str, this.cXR);
            return this;
        }

        @Override // com.tencent.matrix.resource.analyzer.model.d.a
        public final b eM(String str) {
            com.tencent.matrix.resource.analyzer.a.b.checkNotNull(str, "mClassName");
            this.cXR = new c("any subclass of ".concat(String.valueOf(str)));
            this.cXQ.put(str, this.cXR);
            return this;
        }

        public final b eN(String str) {
            this.cXR.name = str;
            return this;
        }

        public final b eO(String str) {
            this.cXR.cXS = str;
            return this;
        }

        public final b SZ() {
            this.cXR.cXT = true;
            return this;
        }

        @Override // com.tencent.matrix.resource.analyzer.model.d.a
        public final d SY() {
            return new d(this);
        }
    }
}
