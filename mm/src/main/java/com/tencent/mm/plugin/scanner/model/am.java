package com.tencent.mm.plugin.scanner.model;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.al;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class am {
    private al CHN = new al();

    public am() {
        AppMethodBeat.i(51655);
        AppMethodBeat.o(51655);
    }

    public final void aME(String str) {
        AppMethodBeat.i(51656);
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(new StringReader(str));
        String str2 = "";
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 1:
                    al.CHN = this.CHN;
                    break;
                case 2:
                    str2 = newPullParser.getName();
                    if (!str2.equals("name")) {
                        if (!str2.equals("address")) {
                            if (!str2.equals("deliveryAddress")) {
                                if (!str2.equals("homeAddress")) {
                                    if (!str2.equals("workAddress")) {
                                        if (!str2.equals("photo")) {
                                            if (!str2.equals("logo")) {
                                                if (str2.equals("sound")) {
                                                    this.CHN.CHz = h(newPullParser);
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                this.CHN.CHy = h(newPullParser);
                                                break;
                                            }
                                        } else {
                                            this.CHN.CHx = h(newPullParser);
                                            break;
                                        }
                                    } else {
                                        this.CHN.CHE = g(newPullParser);
                                        break;
                                    }
                                } else {
                                    this.CHN.CHD = g(newPullParser);
                                    break;
                                }
                            } else {
                                this.CHN.CHC = g(newPullParser);
                                break;
                            }
                        } else {
                            this.CHN.CHB = g(newPullParser);
                            break;
                        }
                    } else {
                        this.CHN.CHw = new al.b(newPullParser.getAttributeValue(null, "firstName"), newPullParser.getAttributeValue(null, "middleName"), newPullParser.getAttributeValue(null, "lastName"));
                        break;
                    }
                case 4:
                    String text = newPullParser.getText();
                    if (text != null && text.trim().length() > 0) {
                        String trim = text.trim();
                        if (!str2.equals("nickName")) {
                            if (!str2.equals("photoUrl")) {
                                if (!str2.equals("birthday")) {
                                    if (!str2.equals("mobilePhoneNumber")) {
                                        if (!str2.equals("homePhoneNumber")) {
                                            if (!str2.equals("workPhoneNumber")) {
                                                if (!str2.equals("telAVPhoneNumber")) {
                                                    if (!str2.equals("phoneNumber")) {
                                                        if (!str2.equals(Scopes.EMAIL)) {
                                                            if (!str2.equals("title")) {
                                                                if (!str2.equals("role")) {
                                                                    if (!str2.equals("agent")) {
                                                                        if (!str2.equals("note")) {
                                                                            if (!str2.equals("url")) {
                                                                                if (str2.equals("organization")) {
                                                                                    this.CHN.lRL = trim;
                                                                                    break;
                                                                                } else {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                this.CHN.url = trim;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            this.CHN.CHM = trim;
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        this.CHN.CHL = trim;
                                                                        break;
                                                                    }
                                                                } else {
                                                                    this.CHN.CHK = trim;
                                                                    break;
                                                                }
                                                            } else {
                                                                this.CHN.title = trim;
                                                                break;
                                                            }
                                                        } else {
                                                            this.CHN.fuD = trim;
                                                            break;
                                                        }
                                                    } else {
                                                        al alVar = this.CHN;
                                                        if (alVar.CHJ == null) {
                                                            alVar.CHJ = new ArrayList();
                                                        }
                                                        if (trim != null && !alVar.CHJ.contains(trim)) {
                                                            alVar.CHJ.add(trim);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    al alVar2 = this.CHN;
                                                    if (alVar2.CHI == null) {
                                                        alVar2.CHI = new ArrayList();
                                                    }
                                                    if (trim != null && !alVar2.CHI.contains(trim)) {
                                                        alVar2.CHI.add(trim);
                                                        break;
                                                    }
                                                }
                                            } else {
                                                al alVar3 = this.CHN;
                                                if (alVar3.CHH == null) {
                                                    alVar3.CHH = new ArrayList();
                                                }
                                                if (trim != null && !alVar3.CHH.contains(trim)) {
                                                    alVar3.CHH.add(trim);
                                                    break;
                                                }
                                            }
                                        } else {
                                            al alVar4 = this.CHN;
                                            if (alVar4.CHG == null) {
                                                alVar4.CHG = new ArrayList();
                                            }
                                            if (trim != null && !alVar4.CHG.contains(trim)) {
                                                alVar4.CHG.add(trim);
                                                break;
                                            }
                                        }
                                    } else {
                                        al alVar5 = this.CHN;
                                        if (alVar5.CHF == null) {
                                            alVar5.CHF = new ArrayList();
                                        }
                                        if (trim != null && !alVar5.CHF.contains(trim)) {
                                            alVar5.CHF.add(trim);
                                            break;
                                        }
                                    }
                                } else {
                                    this.CHN.CHA = trim;
                                    break;
                                }
                            } else {
                                this.CHN.lRD = trim;
                                break;
                            }
                        } else {
                            this.CHN.nickName = trim;
                            break;
                        }
                    }
            }
        }
        al.CHN = this.CHN;
        AppMethodBeat.o(51656);
    }

    private static al.a g(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(51657);
        al.a aVar = new al.a(xmlPullParser.getAttributeValue(null, "postOfficeBox"), xmlPullParser.getAttributeValue(null, "extendedAddress"), xmlPullParser.getAttributeValue(null, "street"), xmlPullParser.getAttributeValue(null, TencentExtraKeys.LOCATION_KEY_LOCALITY), xmlPullParser.getAttributeValue(null, "region"), xmlPullParser.getAttributeValue(null, "postalCode"), xmlPullParser.getAttributeValue(null, UserDataStore.COUNTRY));
        AppMethodBeat.o(51657);
        return aVar;
    }

    private static al.c h(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(51658);
        al.c cVar = new al.c(xmlPullParser.getAttributeValue(null, "type"), xmlPullParser.getAttributeValue(null, "buffer"));
        AppMethodBeat.o(51658);
        return cVar;
    }
}
