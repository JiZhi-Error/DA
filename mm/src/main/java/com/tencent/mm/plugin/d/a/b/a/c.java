package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.d.a.b.a.b;
import com.tencent.mm.plugin.d.a.b.a.d;
import com.tencent.mm.plugin.d.a.b.a.g;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2encoder;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> phw = new HashMap<>();
    private static HashMap<String, Long> piF;

    static {
        AppMethodBeat.i(22578);
        HashMap<String, Long> hashMap = new HashMap<>();
        piF = hashMap;
        hashMap.put(h.phL, 1L);
        piF.put(h.phM, 1L);
        piF.put(h.phN, 16L);
        piF.put(h.phO, 16L);
        piF.put(h.phP, 16L);
        piF.put(h.phQ, 16L);
        phw.put(h.phI, 0L);
        phw.put(h.phR, 2L);
        phw.put(h.phU, 4L);
        phw.put(h.phY, 8L);
        AppMethodBeat.o(22578);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 149
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    public static boolean aY(byte[] r13) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.d.a.b.a.c.aY(byte[]):boolean");
    }

    public static String BA(long j2) {
        AppMethodBeat.i(22574);
        for (String str : phw.keySet()) {
            if (phw.get(str).longValue() == j2) {
                AppMethodBeat.o(22574);
                return str;
            }
        }
        if (piF.containsValue(Long.valueOf(j2))) {
            String str2 = h.phI;
            AppMethodBeat.o(22574);
            return str2;
        }
        AppMethodBeat.o(22574);
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long longValue;
        long j2 = 0;
        AppMethodBeat.i(22575);
        if (bluetoothGattService == null) {
            Log.e(TAG, "service is null");
            AppMethodBeat.o(22575);
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        if (!uuid.equalsIgnoreCase(h.phI) || bluetoothGattService.getCharacteristic(UUID.fromString(h.phL)) == null) {
            Long l = phw.get(uuid);
            if (l != null) {
                j2 = l.longValue();
            }
            Log.d(TAG, "service uuid = %s, profileType = %d", uuid, Long.valueOf(j2));
            AppMethodBeat.o(22575);
            return j2;
        }
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        long j3 = 0;
        int i2 = 0;
        while (i2 < characteristics.size()) {
            Long l2 = piF.get(characteristics.get(i2).getUuid().toString());
            if (l2 == null) {
                longValue = 0;
            } else {
                longValue = l2.longValue();
            }
            i2++;
            j3 = longValue | j3;
        }
        Log.d(TAG, "wechat service, profileType = %d", Long.valueOf(j3));
        AppMethodBeat.o(22575);
        return j3;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        AppMethodBeat.i(22576);
        if (bluetoothGattService == null) {
            Log.e(TAG, "service is null");
            AppMethodBeat.o(22576);
            return false;
        }
        long a2 = a(bluetoothGattService);
        if (0 != (1 & a2)) {
            if (bluetoothGattService == null) {
                Log.e(TAG, "service is null");
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.phL));
            if (characteristic == null) {
                Log.e(TAG, "no step measurement characteristic found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties = characteristic.getProperties();
            Log.d(TAG, "step measurement characteristic properties = %d", Integer.valueOf(properties));
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                Log.e(TAG, "step measurement characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic2 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phM));
            if (characteristic2 != null) {
                int properties2 = characteristic2.getProperties();
                if ((properties2 & 2) == 0 || (properties2 & 32) == 0) {
                    Log.e(TAG, "step target characteristic has incorrect proterties(%d)", Integer.valueOf(properties2));
                    AppMethodBeat.o(22576);
                    return false;
                }
            }
            AppMethodBeat.o(22576);
            return true;
        } else if (0 != (2 & a2)) {
            if (bluetoothGattService == null) {
                Log.e(TAG, "service is null");
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic3 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phS));
            if (characteristic3 == null) {
                Log.e(TAG, "weight scale feature characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties3 = characteristic3.getProperties();
            if ((properties3 & 2) == 0) {
                Log.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties3), 2);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic4 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phT));
            if (characteristic4 == null) {
                Log.e(TAG, "weight measurement characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties4 = characteristic4.getProperties();
            if ((properties4 & 32) == 0) {
                Log.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties4), 32);
                AppMethodBeat.o(22576);
                return false;
            }
            AppMethodBeat.o(22576);
            return true;
        } else if (0 != (4 & a2)) {
            if (bluetoothGattService == null) {
                Log.e(TAG, "service is null");
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic5 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phV));
            if (characteristic5 == null) {
                Log.e(TAG, "heart rate measurement characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties5 = characteristic5.getProperties();
            if ((properties5 & 16) == 0) {
                Log.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties5), 16);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic6 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phW));
            if (characteristic6 != null) {
                int properties6 = characteristic6.getProperties();
                if ((properties6 & 2) == 0) {
                    Log.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties6), 2);
                    AppMethodBeat.o(22576);
                    return false;
                }
            }
            BluetoothGattCharacteristic characteristic7 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phX));
            if (characteristic7 != null) {
                int properties7 = characteristic7.getProperties();
                if ((properties7 & 8) == 0) {
                    Log.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties7), 8);
                    AppMethodBeat.o(22576);
                    return false;
                }
            }
            AppMethodBeat.o(22576);
            return true;
        } else if (0 != (8 & a2)) {
            if (bluetoothGattService == null) {
                Log.e(TAG, "service is null");
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic8 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phZ));
            if (characteristic8 == null) {
                Log.e(TAG, "blood pressure measurement characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties8 = characteristic8.getProperties();
            if ((properties8 & 32) == 0) {
                Log.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties8), 32);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic9 = bluetoothGattService.getCharacteristic(UUID.fromString(h.pib));
            if (characteristic9 == null) {
                Log.e(TAG, "blood pressure feature characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties9 = characteristic9.getProperties();
            if ((properties9 & 2) == 0) {
                Log.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties9), 2);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic10 = bluetoothGattService.getCharacteristic(UUID.fromString(h.pia));
            if (characteristic10 != null) {
                int properties10 = characteristic10.getProperties();
                if ((properties10 & 16) == 0) {
                    Log.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties10), 16);
                    AppMethodBeat.o(22576);
                    return false;
                }
            }
            AppMethodBeat.o(22576);
            return true;
        } else if (0 == (a2 & 16)) {
            AppMethodBeat.o(22576);
            return false;
        } else if (bluetoothGattService == null) {
            Log.e(TAG, "service is null");
            AppMethodBeat.o(22576);
            return false;
        } else {
            BluetoothGattCharacteristic characteristic11 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phN));
            if (characteristic11 == null) {
                Log.e(TAG, "light color characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties11 = characteristic11.getProperties();
            if ((properties11 & 32) == 0 || (properties11 & 16) == 0 || (properties11 & 2) == 0 || (properties11 & 8) == 0) {
                Log.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties11), 32);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic12 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phO));
            if (characteristic12 == null) {
                Log.e(TAG, "light work state characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties12 = characteristic12.getProperties();
            if ((properties12 & 32) == 0 || (properties12 & 2) == 0 || (properties12 & 8) == 0) {
                Log.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties12), 32);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic13 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phP));
            if (characteristic13 == null) {
                Log.e(TAG, "light state changed characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties13 = characteristic13.getProperties();
            if ((properties13 & 32) == 0) {
                Log.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties13), 32);
                AppMethodBeat.o(22576);
                return false;
            }
            BluetoothGattCharacteristic characteristic14 = bluetoothGattService.getCharacteristic(UUID.fromString(h.phQ));
            if (characteristic14 == null) {
                Log.e(TAG, "control point characteristic not found");
                AppMethodBeat.o(22576);
                return false;
            }
            int properties14 = characteristic14.getProperties();
            if ((properties14 & 32) == 0 || (properties14 & 8) == 0) {
                Log.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties14), 32);
                AppMethodBeat.o(22576);
                return false;
            }
            AppMethodBeat.o(22576);
            return true;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        byte[] bArr2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(22577);
        if (bluetoothGattCharacteristic == null || bArr == null) {
            Log.e(TAG, "characteristic or recvData is null");
            AppMethodBeat.o(22577);
            return null;
        }
        long j2 = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j2 = a(service);
        } else {
            Log.e(TAG, "the characteristic has no parent service");
        }
        Log.d(TAG, "recv data. uuid = %s, data = %s", uuid, b.bw(bArr));
        if (0 != (1 & j2) && (uuid.equalsIgnoreCase(f.pjh) || uuid.equalsIgnoreCase(f.pji))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                Log.e(f.TAG, "pase step data error");
                z2 = false;
            } else if (uuid == null || (!uuid.equals(f.pjh) && !uuid.equals(f.pji))) {
                Log.e(f.TAG, "uuid is not correct");
                z2 = false;
            } else {
                fVar.pie = uuid;
                int i7 = 4;
                if ((bArr[0] & 2) != 0) {
                    i7 = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i7 += 3;
                }
                if (i7 > bArr.length) {
                    Log.e(f.TAG, "data len is not enough");
                    z2 = false;
                } else {
                    fVar.pjj = 0;
                    int i8 = 1;
                    for (int i9 = 0; i9 < 3; i9++) {
                        fVar.pjj += (bArr[i8] & 255) << (i9 * 8);
                        i8++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.pjk = 0;
                        for (int i10 = 0; i10 < 3; i10++) {
                            fVar.pjk += (bArr[i8] & 255) << (i10 * 8);
                            i8++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.pjl = 0;
                        int i11 = i8;
                        for (int i12 = 0; i12 < 3; i12++) {
                            fVar.pjl += (bArr[i11] & 255) << (i12 * 8);
                            i11++;
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                bArr2 = b.de(fVar);
                Log.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", Integer.valueOf(fVar.pjj), Integer.valueOf(fVar.pjk), Integer.valueOf(fVar.pjl));
            } else {
                Log.e(TAG, "parse step data error");
                bArr2 = null;
            }
        } else if (0 != (2 & j2) && (uuid.equalsIgnoreCase(g.phT) || uuid.equalsIgnoreCase(g.phS))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                Log.e(g.TAG, "characteristicUuid or data is null or nil");
                z = false;
            } else {
                gVar.pie = uuid;
                if (gVar.pie.equalsIgnoreCase(g.phS)) {
                    if (4 > bArr.length) {
                        Log.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", Integer.valueOf(bArr.length));
                        z = false;
                    } else {
                        gVar.pjo = new g.c();
                        gVar.pjo.pjt = (bArr[0] & 1) != 0;
                        gVar.pjo.pju = (bArr[0] & 2) != 0;
                        gVar.pjo.pjv = (bArr[0] & 4) != 0;
                        gVar.pjo.pjw = (byte) ((bArr[0] & 120) >> 3);
                        gVar.pjo.pjx = (byte) (((bArr[0] & 128) >> 7) + ((bArr[1] & 3) << 1));
                        String str = g.TAG;
                        Object[] objArr = new Object[5];
                        objArr[0] = gVar.pjo.pjt ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                        objArr[1] = gVar.pjo.pju ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                        objArr[2] = gVar.pjo.pjv ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                        objArr[3] = Byte.valueOf(gVar.pjo.pjw);
                        objArr[4] = Byte.valueOf(gVar.pjo.pjx);
                        Log.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", objArr);
                    }
                } else if (gVar.pie.equalsIgnoreCase(g.phT)) {
                    byte b2 = bArr[0];
                    int i13 = (b2 & 2) != 0 ? 10 : 3;
                    if ((b2 & 4) != 0) {
                        i13++;
                    }
                    if ((b2 & 8) != 0) {
                        i13 += 4;
                    }
                    if (i13 > bArr.length) {
                        Log.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", Integer.valueOf(bArr.length), Integer.valueOf(i13));
                        z = false;
                    } else {
                        gVar.pjp = new g.b();
                        gVar.pjp.pjq = (b2 & 1) != 0;
                        gVar.pjp.JF = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b2 & 2) != 0) {
                            gVar.pjp.pjr = new g.a();
                            g.a aVar = gVar.pjp.pjr;
                            String str2 = g.TAG;
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = 3;
                            objArr2[2] = 7;
                            Log.d(str2, "data size = %d, offset = %d, lenght = %d", objArr2);
                            if (bArr == null || bArr.length < 10) {
                                Log.e(g.TAG, "data input error");
                            } else {
                                aVar.mYear = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.mMonth = bArr[5] & 255;
                                aVar.mDay = bArr[6] & 255;
                                aVar.piC = bArr[7] & 255;
                                aVar.piD = bArr[8] & 255;
                                aVar.piE = bArr[9] & 255;
                                Log.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(aVar.mYear), Integer.valueOf(aVar.mMonth), Integer.valueOf(aVar.mDay), Integer.valueOf(aVar.piC), Integer.valueOf(aVar.piD), Integer.valueOf(aVar.piE));
                            }
                            i6 = 10;
                        } else {
                            i6 = 3;
                        }
                        if ((b2 & 4) != 0) {
                            gVar.pjp.piv = bArr[i6] & 255;
                            i6++;
                        }
                        if ((b2 & 8) != 0) {
                            gVar.pjp.pjs = (bArr[i6] & 255) + ((bArr[i6 + 1] & 255) << 8);
                            int i14 = i6 + 2;
                            gVar.pjp.mHeight = ((bArr[i14 + 1] & 255) << 8) + (bArr[i14] & 255);
                        }
                        String str3 = g.TAG;
                        Object[] objArr3 = new Object[6];
                        objArr3[0] = gVar.pjp.pjq ? "lb&inch" : "kg&meter";
                        objArr3[1] = Integer.valueOf(gVar.pjp.JF);
                        objArr3[2] = gVar.pjp.pjr == null ? BuildConfig.COMMAND : "object";
                        objArr3[3] = Integer.valueOf(gVar.pjp.piv);
                        objArr3[4] = Integer.valueOf(gVar.pjp.pjs);
                        objArr3[5] = Integer.valueOf(gVar.pjp.mHeight);
                        Log.d(str3, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", objArr3);
                    }
                }
                z = true;
            }
            if (z) {
                bArr2 = b.de(gVar);
                Log.d(TAG, "weight info. weight = %d", Integer.valueOf(gVar.pjp.JF));
            } else {
                Log.e(TAG, "parse weight scale data error");
                bArr2 = null;
            }
        } else if (0 != (4 & j2) && (uuid.equalsIgnoreCase(d.pig) || uuid.equalsIgnoreCase(d.piG) || uuid.equalsIgnoreCase(d.piH))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                Log.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.pie = uuid;
                int length = bArr.length;
                if (dVar.pie.equalsIgnoreCase(d.pig)) {
                    if (bArr.length < 2) {
                        Log.e(d.TAG, "Received data length is not right:".concat(String.valueOf(length)));
                    } else {
                        dVar.piO = new d.a();
                        byte b3 = bArr[0];
                        Log.d(d.TAG, "flag=".concat(String.valueOf((int) b3)));
                        if ((b3 & 1) == 1 && length >= 3) {
                            Log.d(d.TAG, "Value Format = uint16");
                            dVar.piO.piP = ((bArr[2] << 8) & 65280 & 65280) + (bArr[1] & 255);
                            i5 = 3;
                        } else if (length >= 2) {
                            Log.d(d.TAG, "Value Format = uint8");
                            dVar.piO.piP = bArr[1] & 255;
                            i5 = 2;
                        } else {
                            Log.d(d.TAG, "receive data error");
                        }
                        Log.v(d.TAG, "Data received from HR " + dVar.piO.piP);
                        if ((b3 & 6) == 4) {
                            Log.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.piO.piQ = 1;
                        } else if ((b3 & 6) == 6) {
                            Log.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.piO.piQ = 2;
                        } else {
                            Log.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.piO.piQ = 0;
                        }
                        if ((b3 & 8) == 8 && length >= i5 + 2) {
                            Log.d(d.TAG, "Energy Expend Present");
                            int i15 = (bArr[i5 + 1] << 8) & 65280;
                            dVar.piO.piR = (bArr[i5] & 255) + (i15 & 65280);
                            Log.v("H7ConnectThread", "energyExp from HR energyExph " + i15 + " " + dVar.piO.piR);
                            i5 += 2;
                        }
                        if ((b3 & v2encoder.enumCODEC_vcodec2) == 16 && length >= i5 + 2) {
                            Log.d(d.TAG, "RR Interval Present");
                            int i16 = (bArr[i5 + 1] & 255) << 8;
                            dVar.piO.piS = (bArr[i5] & 255) + (i16 & 65280);
                            Log.v(d.TAG, "rrInterval from HR rrIntervalh" + i16 + " " + dVar.piO.piS);
                        }
                    }
                } else if (dVar.pie.equalsIgnoreCase(d.piG)) {
                    switch (bArr[0]) {
                        case 0:
                            dVar.piN = "Other";
                            break;
                        case 1:
                            dVar.piN = "Chest";
                            break;
                        case 2:
                            dVar.piN = "Wrist";
                            break;
                        case 3:
                            dVar.piN = "Finger";
                            break;
                        case 4:
                            dVar.piN = "Hand";
                            break;
                        case 5:
                            dVar.piN = "Ear Lobe";
                            break;
                        case 6:
                            dVar.piN = "Foot";
                            break;
                        default:
                            dVar.piN = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                            break;
                    }
                    Log.d(d.TAG, "position=" + dVar.piN);
                }
                z3 = true;
            }
            if (z3) {
                bArr2 = b.de(dVar);
            } else {
                Log.e(TAG, "parse heart rate data error");
                bArr2 = null;
            }
        } else if (0 != (8 & j2) && (uuid.equalsIgnoreCase(b.pig) || uuid.equalsIgnoreCase(b.pih) || uuid.equalsIgnoreCase(b.pii))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                Log.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.pie = uuid;
                int length2 = bArr.length;
                if (bVar.pie.equalsIgnoreCase(b.pig)) {
                    if (length2 < 7) {
                        Log.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.pip = new b.C0935b();
                        byte b4 = bArr[0];
                        Log.d(b.TAG, "flag=".concat(String.valueOf((int) b4)));
                        if ((b4 & 1) != 0) {
                            Log.d(b.TAG, "the value unit is kPa.");
                            bVar.pip.pis = true;
                        } else {
                            Log.d(b.TAG, "the value unit is mmHg.");
                            bVar.pip.pis = false;
                        }
                        bVar.pip.piz = b.O(bArr, 1);
                        bVar.pip.piA = b.O(bArr, 3);
                        bVar.pip.piB = b.O(bArr, 5);
                        int i17 = 7;
                        if ((b4 & 2) == 0 || length2 < 14) {
                            Log.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            Log.d(b.TAG, "TimeStamp Present.");
                            bVar.pip.pix.P(bArr, 7);
                            i17 = 14;
                        }
                        if ((b4 & 4) == 0 || length2 < i17 + 2) {
                            Log.d(b.TAG, "PulseRate not Present.");
                        } else {
                            Log.d(b.TAG, "PulseRate Present.");
                            bVar.pip.piu = (int) b.O(bArr, i17);
                            i17 += 2;
                            Log.d(b.TAG, "PulseRate =" + bVar.pip.piu);
                        }
                        if ((b4 & 8) != 0) {
                            Log.d(b.TAG, "UserId Present.");
                            i4 = i17 + 1;
                            bVar.pip.piv = bArr[i17];
                            Log.d(b.TAG, "UserId = " + bVar.pip.piv);
                        } else {
                            Log.d(b.TAG, "UserId not Present.");
                            i4 = i17;
                        }
                        if ((b4 & v2encoder.enumCODEC_vcodec2) != 0) {
                            Log.d(b.TAG, "MeasurementStatus Present.");
                            bVar.pip.piw = (bArr[i4] & 255) + ((bArr[i4 + 1] << 8) & 65280 & 65280);
                            Log.d(b.TAG, "MeasurementStatus = " + bVar.pip.piw);
                        } else {
                            Log.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.pie.equalsIgnoreCase(b.pih)) {
                    if (length2 < 3) {
                        Log.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.piq = new b.a();
                        byte b5 = bArr[0];
                        Log.d(b.TAG, "flag=".concat(String.valueOf((int) b5)));
                        if ((b5 & 1) != 0) {
                            Log.d(b.TAG, "the value unit is kPa.");
                            bVar.piq.pis = true;
                        } else {
                            Log.d(b.TAG, "the value unit is mmHg.");
                            bVar.piq.pis = false;
                        }
                        bVar.piq.pit = b.O(bArr, 1);
                        if ((b5 & 2) == 0 || length2 < 10) {
                            Log.d(b.TAG, "TimeStamp not Present.");
                            i2 = 3;
                        } else {
                            Log.d(b.TAG, "TimeStamp Present.");
                            bVar.piq.pix.P(bArr, 3);
                            i2 = 10;
                        }
                        if ((b5 & 4) == 0 || length2 < i2 + 2) {
                            Log.d(b.TAG, "PulseRate not Present.");
                        } else {
                            Log.d(b.TAG, "PulseRate Present.");
                            bVar.piq.piu = (int) b.O(bArr, i2);
                            i2 += 2;
                            Log.d(b.TAG, "PulseRate =" + bVar.piq.piu);
                        }
                        if ((b5 & 8) != 0) {
                            Log.d(b.TAG, "UserId Present.");
                            i3 = i2 + 1;
                            bVar.piq.piv = bArr[i2];
                            Log.d(b.TAG, "UserId = " + bVar.piq.piv);
                        } else {
                            Log.d(b.TAG, "UserId not Present.");
                            i3 = i2;
                        }
                        if ((b5 & v2encoder.enumCODEC_vcodec2) != 0) {
                            Log.d(b.TAG, "MeasurementStatus Present.");
                            bVar.piq.piw = (bArr[i3] & 255) + ((bArr[i3 + 1] << 8) & 65280 & 65280);
                            Log.d(b.TAG, "MeasurementStatus = " + bVar.piq.piw);
                        } else {
                            Log.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.pie.equalsIgnoreCase(b.pii)) {
                    Log.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (length2 < 2) {
                        Log.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.pir = ((bArr[1] << 8) & 65280 & 65280) + (bArr[0] & 255);
                        Log.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.pir);
                    }
                }
                z3 = true;
            }
            if (z3) {
                bArr2 = com.tencent.mm.plugin.exdevice.k.b.de(bVar);
            } else {
                Log.e(TAG, "parse blood pressure data error");
                bArr2 = null;
            }
        } else if (0 == (j2 & 16) || (!uuid.equalsIgnoreCase(e.piU) && !uuid.equalsIgnoreCase(e.piV) && !uuid.equalsIgnoreCase(e.piW) && !uuid.equalsIgnoreCase(e.piX))) {
            Log.e(TAG, "unknown characteristic uuid = %s", uuid);
            bArr2 = null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                Log.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.pie = uuid;
                if (eVar.pie.equalsIgnoreCase(e.piU)) {
                    if (bArr.length != 3) {
                        Log.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.piY = bArr[0];
                        eVar.piZ = bArr[1];
                        eVar.pja = bArr[2];
                    }
                } else if (eVar.pie.equalsIgnoreCase(e.piV)) {
                    if (bArr.length != 1) {
                        Log.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.pjb = bArr[0];
                    }
                } else if (eVar.pie.equalsIgnoreCase(e.piW)) {
                    if (bArr.length < 2) {
                        Log.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.pjc[0] = bArr[0];
                        eVar.pjc[1] = bArr[1];
                    }
                } else if (!eVar.pie.equalsIgnoreCase(e.piX)) {
                    Log.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    Log.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.pjd = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                    eVar.pjf = bArr[2];
                    eVar.pje = bArr[3];
                    if (bArr.length > 4) {
                        eVar.pjg = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.pjg, 0, bArr.length - 4);
                    } else {
                        eVar.pjg = null;
                    }
                }
                z3 = true;
            }
            if (z3) {
                bArr2 = com.tencent.mm.plugin.exdevice.k.b.de(eVar);
            } else {
                Log.e(TAG, "parse light data error");
                bArr2 = null;
            }
        }
        AppMethodBeat.o(22577);
        return bArr2;
    }
}
