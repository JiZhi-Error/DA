package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ObjectMirror extends ValueMirror {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAMES = "propertyNames";

    public enum PropertyKind {
        Named(1),
        Indexed(2);
        
        int index;

        public static PropertyKind valueOf(String str) {
            AppMethodBeat.i(61511);
            PropertyKind propertyKind = (PropertyKind) Enum.valueOf(PropertyKind.class, str);
            AppMethodBeat.o(61511);
            return propertyKind;
        }

        static {
            AppMethodBeat.i(61512);
            AppMethodBeat.o(61512);
        }

        private PropertyKind(int i2) {
            this.index = i2;
        }
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public String toString() {
        AppMethodBeat.i(61513);
        String v8Object = this.v8Object.toString();
        AppMethodBeat.o(61513);
        return v8Object;
    }

    ObjectMirror(V8Object v8Object) {
        super(v8Object);
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isObject() {
        return true;
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i2) {
        AppMethodBeat.i(61514);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i2);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
            String[] strArr = new String[v8Array2.length()];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                strArr[i3] = v8Array2.getString(i3);
            }
            return strArr;
        } finally {
            v8Array.release();
            if (v8Array2 != null) {
                v8Array2.release();
            }
            AppMethodBeat.o(61514);
        }
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i2) {
        AppMethodBeat.i(61515);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i2);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTIES, v8Array);
            return new PropertiesArray(v8Array2);
        } finally {
            v8Array.release();
            if (v8Array2 != null && !v8Array2.isReleased()) {
                v8Array2.release();
            }
            AppMethodBeat.o(61515);
        }
    }
}
