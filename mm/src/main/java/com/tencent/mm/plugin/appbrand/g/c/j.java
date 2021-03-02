package com.tencent.mm.plugin.appbrand.g.c;

import android.text.TextUtils;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.appbrand.g.b.f;
import com.tencent.mm.plugin.appbrand.g.c.b.a;
import com.tencent.mm.plugin.appbrand.g.c.b.b;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class j {
    private XmlPullParser aWB = Xml.newPullParser();

    private j() {
        AppMethodBeat.i(159015);
        AppMethodBeat.o(159015);
    }

    public static j bBE() {
        AppMethodBeat.i(159016);
        j jVar = new j();
        AppMethodBeat.o(159016);
        return jVar;
    }

    public static b Ye(String str) {
        b bVar;
        AppMethodBeat.i(159017);
        if (str == null) {
            AppMethodBeat.o(159017);
            return null;
        }
        if (str.startsWith("NOTIFY") || str.startsWith("HTTP")) {
            b bVar2 = new b();
            String[] split = str.split(APLogFileUtil.SEPARATOR_LINE);
            if (split.length > 0) {
                String[] split2 = split[0].split(" ");
                if (split2[0].startsWith("HTTP")) {
                    bVar2.put("VERSION", split2[0]);
                    bVar2.put("RESPONSE_CODE", split2[1]);
                    bVar2.put("RESPONSE_DESCRIPTION", split2[2]);
                } else {
                    bVar2.put("METHOD", split2[0]);
                    bVar2.put("PATH", split2[1]);
                    bVar2.put("VERSION", split2[2]);
                }
            }
            for (int i2 = 1; i2 < split.length; i2++) {
                String str2 = split[i2];
                int indexOf = str2.indexOf(":");
                bVar2.put(str2.substring(0, indexOf).toUpperCase(), str2.substring(indexOf + 1, str2.length()).trim());
            }
            bVar = bVar2;
        } else {
            bVar = null;
        }
        AppMethodBeat.o(159017);
        return bVar;
    }

    private HashMap<String, a> D(InputStream inputStream) {
        AppMethodBeat.i(159018);
        HashMap<String, a> hashMap = new HashMap<>();
        try {
            this.aWB.setInput(inputStream, ProtocolPackage.ServerEncoding);
            this.aWB.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            int eventType = this.aWB.getEventType();
            while (eventType != 1) {
                String name = this.aWB.getName();
                if (name != null) {
                    switch (eventType) {
                        case 2:
                            a aVar = new a();
                            int attributeCount = this.aWB.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeName = this.aWB.getAttributeName(i2);
                                String attributeValue = this.aWB.getAttributeValue(i2);
                                aVar.lll.put(attributeName, attributeValue);
                                new StringBuilder("attrName=").append(attributeName).append(", attrVal=").append(attributeValue);
                            }
                            eventType = this.aWB.next();
                            if (eventType == 2) {
                                hashMap.put(name, aVar);
                                break;
                            } else if (eventType == 4) {
                                String trim = this.aWB.getText().trim();
                                aVar.value = trim;
                                hashMap.put(name, aVar);
                                new StringBuilder("name=").append(name).append(", value=").append(trim);
                            } else if (eventType == 3) {
                                hashMap.put(name, aVar);
                            }
                        default:
                            eventType = this.aWB.next();
                            break;
                    }
                } else {
                    eventType = this.aWB.next();
                }
            }
        } catch (IOException | XmlPullParserException e2) {
        }
        AppMethodBeat.o(159018);
        return hashMap;
    }

    public final com.tencent.mm.plugin.appbrand.g.b.b E(InputStream inputStream) {
        com.tencent.mm.plugin.appbrand.g.b.b bVar;
        AppMethodBeat.i(159019);
        synchronized (j.class) {
            try {
                this.aWB.setInput(inputStream, ProtocolPackage.ServerEncoding);
                int eventType = this.aWB.getEventType();
                bVar = new com.tencent.mm.plugin.appbrand.g.b.b();
                f fVar = null;
                while (eventType != 1) {
                    switch (eventType) {
                        case 2:
                            String name = this.aWB.getName();
                            if (!"major".equalsIgnoreCase(name)) {
                                if (!"minor".equalsIgnoreCase(name)) {
                                    if (!"deviceType".equalsIgnoreCase(name)) {
                                        if (!"friendlyName".equalsIgnoreCase(name)) {
                                            if (!"UDN".equalsIgnoreCase(name)) {
                                                if (!"manufacturer".equalsIgnoreCase(name)) {
                                                    if (!"service".equalsIgnoreCase(name)) {
                                                        if (!"serviceType".equalsIgnoreCase(name)) {
                                                            if (!"serviceId".equalsIgnoreCase(name)) {
                                                                if (!"controlURL".equalsIgnoreCase(name)) {
                                                                    if (!"eventSubURL".equalsIgnoreCase(name)) {
                                                                        if ("SCPDURL".equalsIgnoreCase(name) && fVar != null) {
                                                                            fVar.lkp = this.aWB.nextText();
                                                                            break;
                                                                        }
                                                                    } else if (fVar != null) {
                                                                        fVar.lkr = this.aWB.nextText();
                                                                        break;
                                                                    }
                                                                } else if (fVar != null) {
                                                                    fVar.lkq = this.aWB.nextText();
                                                                    break;
                                                                }
                                                            } else if (fVar != null) {
                                                                fVar.lko = this.aWB.nextText();
                                                                break;
                                                            }
                                                        } else if (fVar != null) {
                                                            fVar.iBb = this.aWB.nextText();
                                                            break;
                                                        }
                                                    } else {
                                                        fVar = new f();
                                                        break;
                                                    }
                                                } else {
                                                    bVar.ljQ = this.aWB.nextText();
                                                    break;
                                                }
                                            } else {
                                                bVar.ljS = this.aWB.nextText();
                                                break;
                                            }
                                        } else {
                                            bVar.ljP = this.aWB.nextText();
                                            break;
                                        }
                                    } else {
                                        bVar.dGP = this.aWB.nextText();
                                        break;
                                    }
                                } else {
                                    String nextText = this.aWB.nextText();
                                    if (!TextUtils.isEmpty(nextText)) {
                                        bVar.minor = Integer.parseInt(nextText);
                                        break;
                                    }
                                }
                            } else {
                                String nextText2 = this.aWB.nextText();
                                if (!TextUtils.isEmpty(nextText2)) {
                                    bVar.major = Integer.parseInt(nextText2);
                                    break;
                                }
                            }
                            break;
                        case 3:
                            if ("service".equalsIgnoreCase(this.aWB.getName()) && fVar != null) {
                                bVar.ljT.add(fVar);
                                fVar = null;
                                break;
                            }
                    }
                    try {
                        eventType = this.aWB.next();
                    } catch (IOException | XmlPullParserException e2) {
                    }
                }
            } catch (XmlPullParserException e3) {
                bVar = null;
            } catch (IOException e4) {
                bVar = null;
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(159019);
                throw th;
            }
        }
        AppMethodBeat.o(159019);
        return bVar;
    }

    public final HashMap<String, a> Yf(String str) {
        AppMethodBeat.i(159020);
        HashMap<String, a> D = D(new ByteArrayInputStream(str.getBytes()));
        AppMethodBeat.o(159020);
        return D;
    }
}
