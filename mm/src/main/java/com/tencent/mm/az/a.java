package com.tencent.mm.az;

import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String jfE = "";
    public static String jfF = "";
    public String TEXT;
    public String TYPE;
    public ca dTX;
    public String jfG = "";
    public String jfH;
    public LinkedList<String> jfI = new LinkedList<>();
    public LinkedList<Integer> jfJ = new LinkedList<>();
    public LinkedList<Integer> jfK = new LinkedList<>();
    public Map<String, String> values;

    public interface b {
        void a(View view, ca caVar, a aVar, int i2);
    }

    /* access modifiers changed from: protected */
    public abstract boolean aTA();

    public a(Map<String, String> map) {
        this.values = map;
    }

    public a(Map<String, String> map, ca caVar) {
        this.values = map;
        this.dTX = caVar;
    }

    public final boolean ben() {
        if (this.values == null || this.values.size() <= 0) {
            Log.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            return false;
        }
        if (this.values.containsKey(".sysmsg.$type")) {
            this.TYPE = this.values.get(".sysmsg.$type");
        }
        jfE = ".sysmsg." + this.TYPE + ".text";
        if (this.values.containsKey(jfE)) {
            this.TEXT = this.values.get(jfE);
        }
        jfF = ".sysmsg." + this.TYPE + ".link.scene";
        if (this.values.containsKey(jfF)) {
            this.jfH = this.values.get(jfF);
        }
        return aTA();
    }

    /* renamed from: com.tencent.mm.az.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0276a {
        private static HashMap<String, AbstractC0276a> jfL = new HashMap<>();

        public abstract a a(Map<String, String> map, ca caVar);

        public static void a(String str, AbstractC0276a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (jfL) {
                jfL.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, ca caVar) {
            if (map == null) {
                Log.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String nullAs = Util.nullAs(map.get(".sysmsg.$type"), "");
            synchronized (jfL) {
                AbstractC0276a aVar = jfL.get(nullAs.toLowerCase());
                if (aVar == null) {
                    Log.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", nullAs);
                    return null;
                }
                return aVar.a(map, caVar);
            }
        }
    }
}
