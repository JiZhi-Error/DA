package io.flutter.embedding.engine.c;

import android.os.Build;
import com.facebook.GraphRequest;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {
    public e SRo;
    private final k.c SRp = new k.c() {
        /* class io.flutter.embedding.engine.c.m.AnonymousClass1 */

        @Override // io.flutter.plugin.a.k.c
        public final void a(j jVar, k.d dVar) {
            AppMethodBeat.i(10261);
            if (m.this.SRo == null) {
                AppMethodBeat.o(10261);
                return;
            }
            String str = jVar.method;
            Object obj = jVar.SxX;
            new StringBuilder("Received '").append(str).append("' message.");
            io.flutter.a.hwd();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    m.this.SRo.show();
                    dVar.ba(null);
                    AppMethodBeat.o(10261);
                    return;
                case 1:
                    m.this.SRo.hide();
                    dVar.ba(null);
                    AppMethodBeat.o(10261);
                    return;
                case 2:
                    try {
                        JSONArray jSONArray = (JSONArray) obj;
                        m.this.SRo.a(jSONArray.getInt(0), a.cl(jSONArray.getJSONObject(1)));
                        dVar.ba(null);
                        AppMethodBeat.o(10261);
                        return;
                    } catch (NoSuchFieldException | JSONException e2) {
                        dVar.b("error", e2.getMessage(), null);
                        AppMethodBeat.o(10261);
                        return;
                    }
                case 3:
                    m.this.SRo.hxk();
                    dVar.ba(null);
                    AppMethodBeat.o(10261);
                    return;
                case 4:
                    m.this.SRo.atw(((Integer) obj).intValue());
                    AppMethodBeat.o(10261);
                    return;
                case 5:
                    try {
                        m.this.SRo.a(d.cn((JSONObject) obj));
                        dVar.ba(null);
                        AppMethodBeat.o(10261);
                        return;
                    } catch (JSONException e3) {
                        dVar.b("error", e3.getMessage(), null);
                        AppMethodBeat.o(10261);
                        return;
                    }
                case 6:
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        double d2 = jSONObject.getDouble("width");
                        double d3 = jSONObject.getDouble("height");
                        JSONArray jSONArray2 = jSONObject.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i2 = 0; i2 < 16; i2++) {
                            dArr[i2] = jSONArray2.getDouble(i2);
                        }
                        m.this.SRo.a(d2, d3, dArr);
                        AppMethodBeat.o(10261);
                        return;
                    } catch (JSONException e4) {
                        dVar.b("error", e4.getMessage(), null);
                        AppMethodBeat.o(10261);
                        return;
                    }
                case 7:
                    m.this.SRo.hxl();
                    dVar.ba(null);
                    AppMethodBeat.o(10261);
                    return;
                default:
                    dVar.dLv();
                    AppMethodBeat.o(10261);
                    return;
            }
        }
    };
    public final k bbv;

    public interface e {
        void a(double d2, double d3, double[] dArr);

        void a(int i2, a aVar);

        void a(d dVar);

        void atw(int i2);

        void hide();

        void hxk();

        void hxl();

        void show();
    }

    public m(DartExecutor dartExecutor) {
        AppMethodBeat.i(10224);
        this.bbv = new k(dartExecutor, "flutter/textinput", g.SSl);
        this.bbv.a(this.SRp);
        AppMethodBeat.o(10224);
    }

    public static HashMap<Object, Object> g(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(214991);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i2));
        hashMap.put("selectionExtent", Integer.valueOf(i3));
        hashMap.put("composingBase", Integer.valueOf(i4));
        hashMap.put("composingExtent", Integer.valueOf(i5));
        AppMethodBeat.o(214991);
        return hashMap;
    }

    public final void a(int i2, HashMap<String, d> hashMap) {
        AppMethodBeat.i(214992);
        new StringBuilder("Sending message to update editing state for ").append(String.valueOf(hashMap.size())).append(" field(s).");
        io.flutter.a.hwd();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, d> entry : hashMap.entrySet()) {
            d value = entry.getValue();
            hashMap2.put(entry.getKey(), g(value.text, value.selectionStart, value.selectionEnd, -1, -1));
        }
        this.bbv.a("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i2), hashMap2), null);
        AppMethodBeat.o(214992);
    }

    public static class a {
        public final boolean SRr;
        public final boolean SRs;
        public final boolean SRt;
        public final c SRu;
        public final b SRv;
        public final Integer SRw;
        public final String SRx;
        public final C2249a SRy;
        public final a[] SRz;

        public static a cl(JSONObject jSONObject) {
            a[] aVarArr;
            int i2;
            C2249a aVar = null;
            AppMethodBeat.i(214984);
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                JSONException jSONException = new JSONException("Configuration JSON missing 'inputAction' property.");
                AppMethodBeat.o(214984);
                throw jSONException;
            }
            if (!jSONObject.isNull(GraphRequest.FIELDS_PARAM)) {
                JSONArray jSONArray = jSONObject.getJSONArray(GraphRequest.FIELDS_PARAM);
                aVarArr = new a[jSONArray.length()];
                for (int i3 = 0; i3 < aVarArr.length; i3++) {
                    aVarArr[i3] = cl(jSONArray.getJSONObject(i3));
                }
            } else {
                aVarArr = null;
            }
            char c2 = 65535;
            switch (string.hashCode()) {
                case -810971940:
                    if (string.equals("TextInputAction.unspecified")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -737377923:
                    if (string.equals("TextInputAction.done")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -737089298:
                    if (string.equals("TextInputAction.next")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -737080013:
                    if (string.equals("TextInputAction.none")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -736940669:
                    if (string.equals("TextInputAction.send")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 469250275:
                    if (string.equals("TextInputAction.search")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1241689507:
                    if (string.equals("TextInputAction.go")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1539450297:
                    if (string.equals("TextInputAction.newline")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 2110497650:
                    if (string.equals("TextInputAction.previous")) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    i2 = 1;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 0;
                    break;
                case 3:
                    i2 = 6;
                    break;
                case 4:
                    i2 = 2;
                    break;
                case 5:
                    i2 = 3;
                    break;
                case 6:
                    i2 = 4;
                    break;
                case 7:
                    i2 = 5;
                    break;
                case '\b':
                    i2 = 7;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            boolean optBoolean = jSONObject.optBoolean("obscureText");
            boolean optBoolean2 = jSONObject.optBoolean("autocorrect", true);
            boolean optBoolean3 = jSONObject.optBoolean("enableSuggestions");
            c bto = c.bto(jSONObject.getString("textCapitalization"));
            JSONObject jSONObject2 = jSONObject.getJSONObject("inputType");
            b bVar = new b(f.btp(jSONObject2.getString("name")), jSONObject2.optBoolean("signed", false), jSONObject2.optBoolean("decimal", false));
            String string2 = jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel");
            if (!jSONObject.isNull("autofill")) {
                aVar = C2249a.cm(jSONObject.getJSONObject("autofill"));
            }
            a aVar2 = new a(optBoolean, optBoolean2, optBoolean3, bto, bVar, i2, string2, aVar, aVarArr);
            AppMethodBeat.o(214984);
            return aVar2;
        }

        /* renamed from: io.flutter.embedding.engine.c.m$a$a  reason: collision with other inner class name */
        public static class C2249a {
            public final String SRA;
            public final String[] SRB;
            public final d SRC;

            public static C2249a cm(JSONObject jSONObject) {
                AppMethodBeat.i(214990);
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String string2 = jSONArray.getString(i2);
                    if (Build.VERSION.SDK_INT >= 26) {
                        char c2 = 65535;
                        switch (string2.hashCode()) {
                            case -2058889126:
                                if (string2.equals("birthdayYear")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case -1917283616:
                                if (string2.equals("oneTimeCode")) {
                                    c2 = 25;
                                    break;
                                }
                                break;
                            case -1844815832:
                                if (string2.equals("creditCardExpirationMonth")) {
                                    c2 = '\t';
                                    break;
                                }
                                break;
                            case -1825589953:
                                if (string2.equals("telephoneNumberNational")) {
                                    c2 = '\"';
                                    break;
                                }
                                break;
                            case -1821235109:
                                if (string2.equals("newPassword")) {
                                    c2 = 23;
                                    break;
                                }
                                break;
                            case -1757573738:
                                if (string2.equals("creditCardSecurityCode")) {
                                    c2 = '\f';
                                    break;
                                }
                                break;
                            case -1682373820:
                                if (string2.equals("creditCardExpirationDay")) {
                                    c2 = '\b';
                                    break;
                                }
                                break;
                            case -1658955742:
                                if (string2.equals("fullStreetAddress")) {
                                    c2 = 15;
                                    break;
                                }
                                break;
                            case -1567118045:
                                if (string2.equals("telephoneNumberDevice")) {
                                    c2 = '!';
                                    break;
                                }
                                break;
                            case -1476752575:
                                if (string2.equals("countryName")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                            case -1413737489:
                                if (string2.equals("middleInitial")) {
                                    c2 = 18;
                                    break;
                                }
                                break;
                            case -1377792129:
                                if (string2.equals("addressCity")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -1249512767:
                                if (string2.equals("gender")) {
                                    c2 = 16;
                                    break;
                                }
                                break;
                            case -1186060294:
                                if (string2.equals("postalAddressExtendedPostalCode")) {
                                    c2 = 29;
                                    break;
                                }
                                break;
                            case -1151034798:
                                if (string2.equals("creditCardNumber")) {
                                    c2 = 11;
                                    break;
                                }
                                break;
                            case -835992323:
                                if (string2.equals("namePrefix")) {
                                    c2 = 21;
                                    break;
                                }
                                break;
                            case -818219584:
                                if (string2.equals("middleName")) {
                                    c2 = 19;
                                    break;
                                }
                                break;
                            case -747304516:
                                if (string2.equals("nameSuffix")) {
                                    c2 = 22;
                                    break;
                                }
                                break;
                            case -613980922:
                                if (string2.equals("creditCardExpirationDate")) {
                                    c2 = 7;
                                    break;
                                }
                                break;
                            case -613352043:
                                if (string2.equals("creditCardExpirationYear")) {
                                    c2 = '\n';
                                    break;
                                }
                                break;
                            case -549230602:
                                if (string2.equals("telephoneNumberCountryCode")) {
                                    c2 = ' ';
                                    break;
                                }
                                break;
                            case -265713450:
                                if (string2.equals(ch.COL_USERNAME)) {
                                    c2 = '#';
                                    break;
                                }
                                break;
                            case 3373707:
                                if (string2.equals("name")) {
                                    c2 = 20;
                                    break;
                                }
                                break;
                            case 96619420:
                                if (string2.equals(Scopes.EMAIL)) {
                                    c2 = '\r';
                                    break;
                                }
                                break;
                            case 253202685:
                                if (string2.equals("addressState")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 588174851:
                                if (string2.equals("birthdayMonth")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 798554127:
                                if (string2.equals("familyName")) {
                                    c2 = 14;
                                    break;
                                }
                                break;
                            case 892233837:
                                if (string2.equals("telephoneNumber")) {
                                    c2 = 31;
                                    break;
                                }
                                break;
                            case 991032982:
                                if (string2.equals("newUsername")) {
                                    c2 = 24;
                                    break;
                                }
                                break;
                            case 1069376125:
                                if (string2.equals("birthday")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1216985755:
                                if (string2.equals("password")) {
                                    c2 = 26;
                                    break;
                                }
                                break;
                            case 1469046696:
                                if (string2.equals("givenName")) {
                                    c2 = 17;
                                    break;
                                }
                                break;
                            case 1662667945:
                                if (string2.equals("postalAddress")) {
                                    c2 = 27;
                                    break;
                                }
                                break;
                            case 1921869058:
                                if (string2.equals("postalAddressExtended")) {
                                    c2 = 28;
                                    break;
                                }
                                break;
                            case 2011152728:
                                if (string2.equals("postalCode")) {
                                    c2 = 30;
                                    break;
                                }
                                break;
                            case 2011773919:
                                if (string2.equals("birthdayDay")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                string2 = "addressLocality";
                                continue;
                            case 1:
                                string2 = "addressRegion";
                                continue;
                            case 2:
                                string2 = "birthDateFull";
                                continue;
                            case 3:
                                string2 = "birthDateDay";
                                continue;
                            case 4:
                                string2 = "birthDateMonth";
                                continue;
                            case 5:
                                string2 = "birthDateYear";
                                continue;
                            case 6:
                                string2 = "addressCountry";
                                continue;
                            case 7:
                                string2 = "creditCardExpirationDate";
                                continue;
                            case '\b':
                                string2 = "creditCardExpirationDay";
                                continue;
                            case '\t':
                                string2 = "creditCardExpirationMonth";
                                continue;
                            case '\n':
                                string2 = "creditCardExpirationYear";
                                continue;
                            case 11:
                                string2 = "creditCardNumber";
                                continue;
                            case '\f':
                                string2 = "creditCardSecurityCode";
                                continue;
                            case '\r':
                                string2 = "emailAddress";
                                continue;
                            case 14:
                                string2 = "personFamilyName";
                                continue;
                            case 15:
                                string2 = "streetAddress";
                                continue;
                            case 16:
                                string2 = "gender";
                                continue;
                            case 17:
                                string2 = "personGivenName";
                                continue;
                            case 18:
                                string2 = "personMiddleInitial";
                                continue;
                            case 19:
                                string2 = "personMiddleName";
                                continue;
                            case 20:
                                string2 = "personName";
                                continue;
                            case 21:
                                string2 = "personNamePrefix";
                                continue;
                            case 22:
                                string2 = "personNameSuffix";
                                continue;
                            case 23:
                                string2 = "newPassword";
                                continue;
                            case 24:
                                string2 = "newUsername";
                                continue;
                            case 25:
                                string2 = "smsOTPCode";
                                continue;
                            case 26:
                                string2 = "password";
                                continue;
                            case 27:
                                string2 = "postalAddress";
                                continue;
                            case 28:
                                string2 = "extendedAddress";
                                continue;
                            case 29:
                                string2 = "extendedPostalCode";
                                continue;
                            case 30:
                                string2 = "postalCode";
                                continue;
                            case 31:
                                string2 = "phoneNumber";
                                continue;
                            case ' ':
                                string2 = "phoneCountryCode";
                                continue;
                            case '!':
                                string2 = "phoneNumberDevice";
                                continue;
                            case '\"':
                                string2 = "phoneNational";
                                continue;
                            case '#':
                                string2 = ch.COL_USERNAME;
                                continue;
                        }
                    }
                    strArr[i2] = string2;
                }
                C2249a aVar = new C2249a(string, strArr, d.cn(jSONObject2));
                AppMethodBeat.o(214990);
                return aVar;
            }

            private C2249a(String str, String[] strArr, d dVar) {
                this.SRA = str;
                this.SRB = strArr;
                this.SRC = dVar;
            }
        }

        private a(boolean z, boolean z2, boolean z3, c cVar, b bVar, Integer num, String str, C2249a aVar, a[] aVarArr) {
            this.SRr = z;
            this.SRs = z2;
            this.SRt = z3;
            this.SRu = cVar;
            this.SRv = bVar;
            this.SRw = num;
            this.SRx = str;
            this.SRy = aVar;
            this.SRz = aVarArr;
        }
    }

    public static class b {
        public final f SRD;
        public final boolean SRE;
        public final boolean SRF;

        public b(f fVar, boolean z, boolean z2) {
            this.SRD = fVar;
            this.SRE = z;
            this.SRF = z2;
        }
    }

    public enum f {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword");
        
        private final String SQl;

        public static f valueOf(String str) {
            AppMethodBeat.i(10246);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(10246);
            return fVar;
        }

        static {
            AppMethodBeat.i(10248);
            AppMethodBeat.o(10248);
        }

        static f btp(String str) {
            AppMethodBeat.i(10247);
            f[] values = values();
            for (f fVar : values) {
                if (fVar.SQl.equals(str)) {
                    AppMethodBeat.o(10247);
                    return fVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such TextInputType: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10247);
            throw noSuchFieldException;
        }

        private f(String str) {
            this.SQl = str;
        }
    }

    public enum c {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        private final String SQl;

        public static c valueOf(String str) {
            AppMethodBeat.i(10258);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(10258);
            return cVar;
        }

        static {
            AppMethodBeat.i(10260);
            AppMethodBeat.o(10260);
        }

        static c bto(String str) {
            AppMethodBeat.i(10259);
            c[] values = values();
            for (c cVar : values) {
                if (cVar.SQl.equals(str)) {
                    AppMethodBeat.o(10259);
                    return cVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such TextCapitalization: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10259);
            throw noSuchFieldException;
        }

        private c(String str) {
            this.SQl = str;
        }
    }

    public static class d {
        public final int selectionEnd;
        public final int selectionStart;
        public final String text;

        public static d cn(JSONObject jSONObject) {
            AppMethodBeat.i(214986);
            d dVar = new d(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"));
            AppMethodBeat.o(214986);
            return dVar;
        }

        public d(String str, int i2, int i3) {
            this.text = str;
            this.selectionStart = i2;
            this.selectionEnd = i3;
        }
    }
}
