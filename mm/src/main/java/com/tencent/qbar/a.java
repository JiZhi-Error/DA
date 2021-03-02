package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qbar.QbarNative;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class a {
    protected int RJt = -1;
    protected QbarNative RJu = new QbarNative();

    /* renamed from: com.tencent.qbar.a$a  reason: collision with other inner class name */
    public static class C2180a {
        public String charset;
        public String data;
        public int priorityLevel;
        public byte[] rawData;
        public int typeID;
        public String typeName;
    }

    public a() {
        AppMethodBeat.i(88393);
        AppMethodBeat.o(88393);
    }

    public static String getVersion() {
        AppMethodBeat.i(88394);
        String GetVersion = QbarNative.GetVersion();
        AppMethodBeat.o(88394);
        return GetVersion;
    }

    public final int a(int i2, String str, String str2, QbarNative.QbarAiModelParam qbarAiModelParam) {
        int i3;
        AppMethodBeat.i(88395);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    this.RJt = this.RJu.Init(1, i2, str, str2, qbarAiModelParam);
                }
                System.out.println("qbarId:" + this.RJt);
                if (this.RJt < 0) {
                    i3 = -1;
                } else {
                    i3 = 0;
                    AppMethodBeat.o(88395);
                }
            } finally {
                AppMethodBeat.o(88395);
            }
        }
        return i3;
    }

    public final int l(int[] iArr, int i2) {
        int SetReaders;
        AppMethodBeat.i(88396);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    SetReaders = -1;
                } else {
                    SetReaders = this.RJu.SetReaders(iArr, i2, this.RJt);
                    AppMethodBeat.o(88396);
                }
            } finally {
                AppMethodBeat.o(88396);
            }
        }
        return SetReaders;
    }

    public int S(byte[] bArr, int i2, int i3) {
        int ScanImage;
        AppMethodBeat.i(88397);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    ScanImage = -1;
                } else {
                    ScanImage = this.RJu.ScanImage(bArr, i2, i3, this.RJt);
                    AppMethodBeat.o(88397);
                }
            } finally {
                AppMethodBeat.o(88397);
            }
        }
        return ScanImage;
    }

    public final int release() {
        int Release;
        AppMethodBeat.i(88398);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    Release = 0;
                } else {
                    Release = this.RJu.Release(this.RJt);
                    this.RJt = -1;
                    AppMethodBeat.o(88398);
                }
            } finally {
                AppMethodBeat.o(88398);
            }
        }
        return Release;
    }

    public final List<C2180a> hkc() {
        ArrayList arrayList;
        AppMethodBeat.i(88399);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    arrayList = null;
                } else {
                    QbarNative.QBarResultJNI[] qBarResultJNIArr = new QbarNative.QBarResultJNI[3];
                    for (int i2 = 0; i2 < 3; i2++) {
                        qBarResultJNIArr[i2] = new QbarNative.QBarResultJNI();
                        qBarResultJNIArr[i2].charset = new String();
                        qBarResultJNIArr[i2].data = new byte[1024];
                        qBarResultJNIArr[i2].typeName = new String();
                    }
                    this.RJu.GetResults(qBarResultJNIArr, this.RJt);
                    arrayList = new ArrayList();
                    for (int i3 = 0; i3 < 3; i3++) {
                        try {
                            QbarNative.QBarResultJNI qBarResultJNI = qBarResultJNIArr[i3];
                            if (qBarResultJNI.typeName != null && !qBarResultJNI.typeName.isEmpty()) {
                                C2180a aVar = new C2180a();
                                aVar.charset = qBarResultJNI.charset;
                                aVar.typeID = qBarResultJNI.typeID;
                                aVar.typeName = qBarResultJNI.typeName;
                                aVar.rawData = qBarResultJNI.data;
                                if (aVar.charset.equals("ANY")) {
                                    aVar.data = new String(qBarResultJNI.data, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                                } else {
                                    aVar.data = new String(qBarResultJNI.data, aVar.charset);
                                }
                                arrayList.add(aVar);
                            }
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                    AppMethodBeat.o(88399);
                }
            } finally {
                AppMethodBeat.o(88399);
            }
        }
        return arrayList;
    }

    public final QbarNative.QBarZoomInfo hkd() {
        QbarNative.QBarZoomInfo qBarZoomInfo;
        AppMethodBeat.i(88400);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    qBarZoomInfo = null;
                } else {
                    qBarZoomInfo = new QbarNative.QBarZoomInfo();
                    this.RJu.GetZoomInfo(qBarZoomInfo, this.RJt);
                    AppMethodBeat.o(88400);
                }
            } finally {
                AppMethodBeat.o(88400);
            }
        }
        return qBarZoomInfo;
    }

    public final int F(List<QbarNative.QBarCodeDetectInfo> list, List<QbarNative.QBarPoint> list2) {
        int i2 = 0;
        AppMethodBeat.i(88401);
        synchronized (this) {
            try {
                if (this.RJt >= 0) {
                    QbarNative.QBarCodeDetectInfo[] qBarCodeDetectInfoArr = new QbarNative.QBarCodeDetectInfo[3];
                    QbarNative.QBarPoint[] qBarPointArr = new QbarNative.QBarPoint[3];
                    for (int i3 = 0; i3 < 3; i3++) {
                        qBarCodeDetectInfoArr[i3] = new QbarNative.QBarCodeDetectInfo();
                        qBarPointArr[i3] = new QbarNative.QBarPoint();
                    }
                    list.clear();
                    list2.clear();
                    this.RJu.GetCodeDetectInfo(qBarCodeDetectInfoArr, qBarPointArr, this.RJt);
                    for (int i4 = 0; i4 < 3; i4++) {
                        QbarNative.QBarCodeDetectInfo qBarCodeDetectInfo = qBarCodeDetectInfoArr[i4];
                        if (qBarCodeDetectInfo.readerId > 0) {
                            list.add(qBarCodeDetectInfo);
                        }
                    }
                    while (i2 < 3) {
                        QbarNative.QBarPoint qBarPoint = qBarPointArr[i2];
                        if (qBarPoint.point_cnt != 0) {
                            list2.add(qBarPoint);
                        }
                        i2++;
                    }
                    i2 = list.size();
                    AppMethodBeat.o(88401);
                }
            } finally {
                AppMethodBeat.o(88401);
            }
        }
        return i2;
    }

    public static int a(byte[] bArr, int[] iArr, String str, int i2, int i3, String str2) {
        AppMethodBeat.i(88402);
        int Encode = QbarNative.Encode(bArr, iArr, str, i2, i3, str2, -1);
        AppMethodBeat.o(88402);
        return Encode;
    }
}
