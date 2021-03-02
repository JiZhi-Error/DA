package com.qq.a.a;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    protected HashMap<String, HashMap<String, byte[]>> cge = new HashMap<>();
    private HashMap<String, Object> cgf = new HashMap<>(128);
    private HashMap<String, Object> cgg = new HashMap<>(128);
    protected String cgh = "GBK";
    JceInputStream cgj = new JceInputStream();

    static {
        AppMethodBeat.i(187108);
        AppMethodBeat.o(187108);
    }

    public <T> void put(String str, T t) {
        AppMethodBeat.i(187099);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.o(187099);
            throw illegalArgumentException;
        } else if (t == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.o(187099);
            throw illegalArgumentException2;
        } else if (t instanceof Set) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("can not support Set");
            AppMethodBeat.o(187099);
            throw illegalArgumentException3;
        } else {
            JceOutputStream jceOutputStream = new JceOutputStream();
            jceOutputStream.setServerEncoding(this.cgh);
            jceOutputStream.write((Object) t, 0);
            byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
            HashMap<String, byte[]> hashMap = new HashMap<>(1);
            ArrayList<String> arrayList = new ArrayList<>(1);
            c(arrayList, t);
            hashMap.put(a.d(arrayList), jceBufArray);
            this.cgg.remove(str);
            this.cge.put(str, hashMap);
            AppMethodBeat.o(187099);
        }
    }

    private void c(ArrayList<String> arrayList, Object obj) {
        AppMethodBeat.i(187100);
        Object obj2 = obj;
        while (true) {
            if (obj2.getClass().isArray()) {
                if (!obj2.getClass().getComponentType().toString().equals("byte")) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("only byte[] is supported");
                    AppMethodBeat.o(187100);
                    throw illegalArgumentException;
                } else if (Array.getLength(obj2) > 0) {
                    arrayList.add("java.util.List");
                    obj2 = Array.get(obj2, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    AppMethodBeat.o(187100);
                    return;
                }
            } else if (obj2 instanceof Array) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("can not support Array, please use List");
                AppMethodBeat.o(187100);
                throw illegalArgumentException2;
            } else if (obj2 instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj2;
                if (list.size() > 0) {
                    obj2 = list.get(0);
                } else {
                    arrayList.add("?");
                    AppMethodBeat.o(187100);
                    return;
                }
            } else if (obj2 instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj2;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                } else {
                    arrayList.add("?");
                    arrayList.add("?");
                    AppMethodBeat.o(187100);
                    return;
                }
            } else {
                arrayList.add(obj2.getClass().getName());
                AppMethodBeat.o(187100);
                return;
            }
        }
    }

    public byte[] IJ() {
        AppMethodBeat.i(187101);
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.cgh);
        jceOutputStream.write((Map) this.cge, 0);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        AppMethodBeat.o(187101);
        return jceBufArray;
    }

    public b() {
        AppMethodBeat.i(187102);
        AppMethodBeat.o(187102);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(187103);
        boolean equals = JceUtil.equals((Object) 1, (Object) ((b) obj).cge);
        AppMethodBeat.o(187103);
        return equals;
    }

    @Override // java.lang.Object
    public Object clone() {
        AppMethodBeat.i(187104);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(187104);
                throw assertionError;
            }
        }
        AppMethodBeat.o(187104);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(187105);
        jceOutputStream.write((Map) this.cge, 0);
        AppMethodBeat.o(187105);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(187106);
        this.cge.clear();
        HashMap<String, byte[]> hashMap = new HashMap<>();
        byte[] bArr = new byte[1];
        Byte b2 = (byte) 0;
        bArr[0] = b2.byteValue();
        hashMap.put("", bArr);
        this.cge.put("", hashMap);
        this.cge = (HashMap) jceInputStream.read((Object) this.cge, 0, true);
        AppMethodBeat.o(187106);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(187107);
        new JceDisplayer(sb, i2).display((Map) this.cge, "_data");
        AppMethodBeat.o(187107);
    }
}
