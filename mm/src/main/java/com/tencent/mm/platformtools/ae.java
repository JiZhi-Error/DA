package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class ae {
    public final int action;
    public final String content;
    public final int dGe;
    public final int errorCode;
    public final int jPP;
    public final String title;
    public final int type;
    public final String url;

    public ae(int i2, int i3, String str) {
        int i4;
        int i5;
        int i6;
        String str2;
        String str3;
        Exception e2;
        AppMethodBeat.i(127752);
        String str4 = "";
        int i7 = 5;
        try {
            Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
            if (parseXml == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("values == null");
                AppMethodBeat.o(127752);
                throw illegalArgumentException;
            }
            i4 = Integer.valueOf(parseXml.get(".e.ShowType")).intValue();
            try {
                i5 = Integer.valueOf(parseXml.get(".e.Action")).intValue();
                try {
                    i6 = Integer.valueOf(parseXml.get(".e.DispSec")).intValue();
                } catch (Exception e3) {
                    e2 = e3;
                    str3 = "";
                    str2 = "";
                    Log.e("MicroMsg.UnifyErrorProcessor", e2.toString());
                    i6 = i7;
                    this.errorCode = i3;
                    this.dGe = i2;
                    this.type = i4;
                    this.action = i5;
                    this.content = str4;
                    this.jPP = i6;
                    this.title = str3;
                    this.url = str2;
                    AppMethodBeat.o(127752);
                }
            } catch (Exception e4) {
                e2 = e4;
                str3 = "";
                str2 = "";
                i5 = 0;
                Log.e("MicroMsg.UnifyErrorProcessor", e2.toString());
                i6 = i7;
                this.errorCode = i3;
                this.dGe = i2;
                this.type = i4;
                this.action = i5;
                this.content = str4;
                this.jPP = i6;
                this.title = str3;
                this.url = str2;
                AppMethodBeat.o(127752);
            }
            try {
                str3 = parseXml.get(".e.Title");
                try {
                    str2 = parseXml.get(".e.Url");
                    try {
                        str4 = parseXml.get(".e.Content");
                    } catch (Exception e5) {
                        e2 = e5;
                        i7 = i6;
                        Log.e("MicroMsg.UnifyErrorProcessor", e2.toString());
                        i6 = i7;
                        this.errorCode = i3;
                        this.dGe = i2;
                        this.type = i4;
                        this.action = i5;
                        this.content = str4;
                        this.jPP = i6;
                        this.title = str3;
                        this.url = str2;
                        AppMethodBeat.o(127752);
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    str2 = "";
                    i7 = i6;
                    Log.e("MicroMsg.UnifyErrorProcessor", e2.toString());
                    i6 = i7;
                    this.errorCode = i3;
                    this.dGe = i2;
                    this.type = i4;
                    this.action = i5;
                    this.content = str4;
                    this.jPP = i6;
                    this.title = str3;
                    this.url = str2;
                    AppMethodBeat.o(127752);
                }
            } catch (Exception e7) {
                e2 = e7;
                str3 = "";
                str2 = "";
                i7 = i6;
                Log.e("MicroMsg.UnifyErrorProcessor", e2.toString());
                i6 = i7;
                this.errorCode = i3;
                this.dGe = i2;
                this.type = i4;
                this.action = i5;
                this.content = str4;
                this.jPP = i6;
                this.title = str3;
                this.url = str2;
                AppMethodBeat.o(127752);
            }
            this.errorCode = i3;
            this.dGe = i2;
            this.type = i4;
            this.action = i5;
            this.content = str4;
            this.jPP = i6;
            this.title = str3;
            this.url = str2;
            AppMethodBeat.o(127752);
        } catch (Exception e8) {
            e2 = e8;
            str3 = "";
            str2 = "";
            i5 = 0;
            i4 = 0;
            Log.e("MicroMsg.UnifyErrorProcessor", e2.toString());
            i6 = i7;
            this.errorCode = i3;
            this.dGe = i2;
            this.type = i4;
            this.action = i5;
            this.content = str4;
            this.jPP = i6;
            this.title = str3;
            this.url = str2;
            AppMethodBeat.o(127752);
        }
    }
}
