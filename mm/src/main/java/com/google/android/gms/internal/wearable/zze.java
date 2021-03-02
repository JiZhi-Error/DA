package com.google.android.gms.internal.wearable;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@VisibleForTesting
public final class zze {
    public static zzf zza(DataMap dataMap) {
        AppMethodBeat.i(100657);
        zzg zzg = new zzg();
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        zzh[] zzhArr = new zzh[treeSet.size()];
        int i2 = 0;
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            zzhArr[i2] = new zzh();
            zzhArr[i2].name = str;
            zzhArr[i2].zzga = zza(arrayList, obj);
            i2++;
        }
        zzg.zzfy = zzhArr;
        zzf zzf = new zzf(zzg, arrayList);
        AppMethodBeat.o(100657);
        return zzf;
    }

    private static zzi zza(List<Asset> list, Object obj) {
        int i2 = 0;
        AppMethodBeat.i(100659);
        zzi zzi = new zzi();
        if (obj == null) {
            zzi.type = 14;
            AppMethodBeat.o(100659);
            return zzi;
        }
        zzi.zzgc = new zzj();
        if (obj instanceof String) {
            zzi.type = 2;
            zzi.zzgc.zzge = (String) obj;
        } else if (obj instanceof Integer) {
            zzi.type = 6;
            zzi.zzgc.zzgi = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            zzi.type = 5;
            zzi.zzgc.zzgh = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            zzi.type = 3;
            zzi.zzgc.zzgf = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            zzi.type = 4;
            zzi.zzgc.zzgg = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            zzi.type = 8;
            zzi.zzgc.zzgk = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            zzi.type = 7;
            zzi.zzgc.zzgj = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            zzi.type = 1;
            zzi.zzgc.zzgd = (byte[]) obj;
        } else if (obj instanceof String[]) {
            zzi.type = 11;
            zzi.zzgc.zzgn = (String[]) obj;
        } else if (obj instanceof long[]) {
            zzi.type = 12;
            zzi.zzgc.zzgo = (long[]) obj;
        } else if (obj instanceof float[]) {
            zzi.type = 15;
            zzi.zzgc.zzgp = (float[]) obj;
        } else if (obj instanceof Asset) {
            zzi.type = 13;
            zzj zzj = zzi.zzgc;
            list.add((Asset) obj);
            zzj.zzgq = (long) (list.size() - 1);
        } else if (obj instanceof DataMap) {
            zzi.type = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.keySet());
            zzh[] zzhArr = new zzh[treeSet.size()];
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                zzhArr[i2] = new zzh();
                zzhArr[i2].name = str;
                zzhArr[i2].zzga = zza(list, dataMap.get(str));
                i2++;
            }
            zzi.zzgc.zzgl = zzhArr;
        } else if (obj instanceof ArrayList) {
            zzi.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            zzi[] zziArr = new zzi[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 14;
            while (i3 < size) {
                Object obj3 = arrayList.get(i3);
                zzi zza = zza(list, obj3);
                if (zza.type == 14 || zza.type == 2 || zza.type == 6 || zza.type == 9) {
                    if (i4 == 14 && zza.type != 14) {
                        i4 = zza.type;
                    } else if (zza.type != i4) {
                        String valueOf = String.valueOf(obj2.getClass());
                        String valueOf2 = String.valueOf(obj3.getClass());
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 80 + String.valueOf(valueOf2).length()).append("ArrayList elements must all be of the sameclass, but this one contains a ").append(valueOf).append(" and a ").append(valueOf2).toString());
                        AppMethodBeat.o(100659);
                        throw illegalArgumentException;
                    } else {
                        obj3 = obj2;
                    }
                    zziArr[i3] = zza;
                    i3++;
                    obj2 = obj3;
                } else {
                    String valueOf3 = String.valueOf(obj3.getClass());
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf3).length() + 130).append("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a ").append(valueOf3).toString());
                    AppMethodBeat.o(100659);
                    throw illegalArgumentException2;
                }
            }
            zzi.zzgc.zzgm = zziArr;
        } else {
            String valueOf4 = String.valueOf(obj.getClass().getSimpleName());
            RuntimeException runtimeException = new RuntimeException(valueOf4.length() != 0 ? "newFieldValueFromValue: unexpected value ".concat(valueOf4) : new String("newFieldValueFromValue: unexpected value "));
            AppMethodBeat.o(100659);
            throw runtimeException;
        }
        AppMethodBeat.o(100659);
        return zzi;
    }

    public static DataMap zza(zzf zzf) {
        AppMethodBeat.i(100658);
        DataMap dataMap = new DataMap();
        zzh[] zzhArr = zzf.zzfw.zzfy;
        for (zzh zzh : zzhArr) {
            zza(zzf.zzfx, dataMap, zzh.name, zzh.zzga);
        }
        AppMethodBeat.o(100658);
        return dataMap;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzi zzi) {
        AppMethodBeat.i(100660);
        int i2 = zzi.type;
        if (i2 == 14) {
            dataMap.putString(str, null);
            AppMethodBeat.o(100660);
            return;
        }
        zzj zzj = zzi.zzgc;
        if (i2 == 1) {
            dataMap.putByteArray(str, zzj.zzgd);
            AppMethodBeat.o(100660);
        } else if (i2 == 11) {
            dataMap.putStringArray(str, zzj.zzgn);
            AppMethodBeat.o(100660);
        } else if (i2 == 12) {
            dataMap.putLongArray(str, zzj.zzgo);
            AppMethodBeat.o(100660);
        } else if (i2 == 15) {
            dataMap.putFloatArray(str, zzj.zzgp);
            AppMethodBeat.o(100660);
        } else if (i2 == 2) {
            dataMap.putString(str, zzj.zzge);
            AppMethodBeat.o(100660);
        } else if (i2 == 3) {
            dataMap.putDouble(str, zzj.zzgf);
            AppMethodBeat.o(100660);
        } else if (i2 == 4) {
            dataMap.putFloat(str, zzj.zzgg);
            AppMethodBeat.o(100660);
        } else if (i2 == 5) {
            dataMap.putLong(str, zzj.zzgh);
            AppMethodBeat.o(100660);
        } else if (i2 == 6) {
            dataMap.putInt(str, zzj.zzgi);
            AppMethodBeat.o(100660);
        } else if (i2 == 7) {
            dataMap.putByte(str, (byte) zzj.zzgj);
            AppMethodBeat.o(100660);
        } else if (i2 == 8) {
            dataMap.putBoolean(str, zzj.zzgk);
            AppMethodBeat.o(100660);
        } else if (i2 == 13) {
            if (list == null) {
                String valueOf = String.valueOf(str);
                RuntimeException runtimeException = new RuntimeException(valueOf.length() != 0 ? "populateBundle: unexpected type for: ".concat(valueOf) : new String("populateBundle: unexpected type for: "));
                AppMethodBeat.o(100660);
                throw runtimeException;
            }
            dataMap.putAsset(str, list.get((int) zzj.zzgq));
            AppMethodBeat.o(100660);
        } else if (i2 == 9) {
            DataMap dataMap2 = new DataMap();
            zzh[] zzhArr = zzj.zzgl;
            for (zzh zzh : zzhArr) {
                zza(list, dataMap2, zzh.name, zzh.zzga);
            }
            dataMap.putDataMap(str, dataMap2);
            AppMethodBeat.o(100660);
        } else if (i2 == 10) {
            zzi[] zziArr = zzj.zzgm;
            int i3 = 14;
            for (zzi zzi2 : zziArr) {
                if (i3 == 14) {
                    if (zzi2.type == 9 || zzi2.type == 2 || zzi2.type == 6) {
                        i3 = zzi2.type;
                    } else if (zzi2.type != 14) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 48).append("Unexpected TypedValue type: ").append(zzi2.type).append(" for key ").append(str).toString());
                        AppMethodBeat.o(100660);
                        throw illegalArgumentException;
                    }
                } else if (zzi2.type != i3) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 126).append("The ArrayList elements should all be the same type, but ArrayList with key ").append(str).append(" contains items of type ").append(i3).append(" and ").append(zzi2.type).toString());
                    AppMethodBeat.o(100660);
                    throw illegalArgumentException2;
                }
            }
            ArrayList<Integer> arrayList = new ArrayList<>(zzj.zzgm.length);
            zzi[] zziArr2 = zzj.zzgm;
            for (zzi zzi3 : zziArr2) {
                if (zzi3.type == 14) {
                    arrayList.add(null);
                } else if (i3 == 9) {
                    DataMap dataMap3 = new DataMap();
                    zzh[] zzhArr2 = zzi3.zzgc.zzgl;
                    for (zzh zzh2 : zzhArr2) {
                        zza(list, dataMap3, zzh2.name, zzh2.zzga);
                    }
                    arrayList.add(dataMap3);
                } else if (i3 == 2) {
                    arrayList.add(zzi3.zzgc.zzge);
                } else if (i3 == 6) {
                    arrayList.add(Integer.valueOf(zzi3.zzgc.zzgi));
                } else {
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(new StringBuilder(39).append("Unexpected typeOfArrayList: ").append(i3).toString());
                    AppMethodBeat.o(100660);
                    throw illegalArgumentException3;
                }
            }
            if (i3 == 14) {
                dataMap.putStringArrayList(str, arrayList);
                AppMethodBeat.o(100660);
            } else if (i3 == 9) {
                dataMap.putDataMapArrayList(str, arrayList);
                AppMethodBeat.o(100660);
            } else if (i3 == 2) {
                dataMap.putStringArrayList(str, arrayList);
                AppMethodBeat.o(100660);
            } else if (i3 == 6) {
                dataMap.putIntegerArrayList(str, arrayList);
                AppMethodBeat.o(100660);
            } else {
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(39).append("Unexpected typeOfArrayList: ").append(i3).toString());
                AppMethodBeat.o(100660);
                throw illegalStateException;
            }
        } else {
            RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(43).append("populateBundle: unexpected type ").append(i2).toString());
            AppMethodBeat.o(100660);
            throw runtimeException2;
        }
    }
}
