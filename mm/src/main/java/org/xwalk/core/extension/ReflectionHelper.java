package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

/* access modifiers changed from: package-private */
public class ReflectionHelper {
    private static final String TAG = "JsStubReflectHelper";
    static Set<Class<?>> primitives = new HashSet();
    private Map<String, String> bindingClasses = new HashMap();
    private Map<String, ReflectionHelper> constructorReflections = new HashMap();
    private MemberInfo entryPoint = null;
    private String[] eventList = null;
    private Map<String, MemberInfo> members = new HashMap();
    private Class<?> myClass;

    static {
        AppMethodBeat.i(155274);
        AppMethodBeat.o(155274);
    }

    public enum MemberType {
        JS_METHOD,
        JS_PROPERTY,
        JS_CONSTRUCTOR;

        public static MemberType valueOf(String str) {
            AppMethodBeat.i(155252);
            MemberType memberType = (MemberType) Enum.valueOf(MemberType.class, str);
            AppMethodBeat.o(155252);
            return memberType;
        }

        static {
            AppMethodBeat.i(155253);
            AppMethodBeat.o(155253);
        }
    }

    public class MemberInfo {
        AccessibleObject accesser;
        boolean isEntryPoint;
        boolean isStatic;
        boolean isWritable;
        String javaName;
        String jsName;
        Class<?> mainClass;
        MemberType type;
        boolean withPromise;
        String wrapArgs = "";
        String wrapReturns = "";

        public MemberInfo() {
        }
    }

    public ReflectionHelper(Class<?> cls) {
        AppMethodBeat.i(155254);
        this.myClass = cls;
        init();
        AppMethodBeat.o(155254);
    }

    /* access modifiers changed from: package-private */
    public void getMemberInfo(AccessibleObject[] accessibleObjectArr, MemberType memberType) {
        AppMethodBeat.i(155255);
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.isAnnotationPresent(JsApi.class) || accessibleObject.isAnnotationPresent(JsConstructor.class)) {
                MemberInfo memberInfo = new MemberInfo();
                String name = ((Member) accessibleObject).getName();
                memberInfo.javaName = name;
                memberInfo.accesser = accessibleObject;
                memberInfo.isStatic = Modifier.isStatic(((Member) accessibleObject).getModifiers());
                if (accessibleObject.isAnnotationPresent(JsApi.class)) {
                    JsApi jsApi = (JsApi) accessibleObject.getAnnotation(JsApi.class);
                    if (memberType != MemberType.JS_PROPERTY || !jsApi.isEventList()) {
                        memberInfo.type = memberType;
                        memberInfo.isWritable = jsApi.isWritable();
                        memberInfo.isEntryPoint = jsApi.isEntryPoint();
                        memberInfo.withPromise = jsApi.withPromise();
                        memberInfo.jsName = name;
                        memberInfo.wrapArgs = jsApi.wrapArgs();
                        memberInfo.wrapReturns = jsApi.wrapReturns();
                    } else if (!((Field) accessibleObject).getType().equals(String[].class)) {
                        Log.w(TAG, "Invalid type for Supported JS event list".concat(String.valueOf(name)));
                    } else {
                        try {
                            this.eventList = (String[]) ((Field) accessibleObject).get(null);
                        } catch (IllegalAccessException | IllegalArgumentException e2) {
                        }
                    }
                } else if (accessibleObject.isAnnotationPresent(JsConstructor.class)) {
                    if (memberType != MemberType.JS_METHOD) {
                        Log.w(TAG, "Invalid @JsConstructor on non-function member:".concat(String.valueOf(name)));
                    } else {
                        JsConstructor jsConstructor = (JsConstructor) accessibleObject.getAnnotation(JsConstructor.class);
                        memberInfo.type = MemberType.JS_CONSTRUCTOR;
                        memberInfo.isEntryPoint = jsConstructor.isEntryPoint();
                        memberInfo.mainClass = jsConstructor.mainClass();
                        memberInfo.withPromise = false;
                        if (memberInfo.mainClass != null) {
                            memberInfo.jsName = memberInfo.mainClass.getSimpleName();
                            this.bindingClasses.put(memberInfo.mainClass.getName(), memberInfo.jsName);
                            this.constructorReflections.put(memberInfo.jsName, new ReflectionHelper(memberInfo.mainClass));
                        }
                    }
                }
                if (memberInfo.isEntryPoint) {
                    if (this.entryPoint != null) {
                        Log.w(TAG, "Entry point already exist, try to set another:" + memberInfo.jsName);
                    } else if (memberType != MemberType.JS_PROPERTY || isBindingClass(((Field) memberInfo.accesser).getType())) {
                        this.entryPoint = memberInfo;
                    } else {
                        Log.w(TAG, "Invalid entry point setting on property:".concat(String.valueOf(name)));
                    }
                }
                if (this.members.containsKey(memberInfo.jsName)) {
                    Log.w(TAG, "Conflict namespace - " + memberInfo.jsName);
                } else {
                    this.members.put(memberInfo.jsName, memberInfo);
                }
            }
        }
        AppMethodBeat.o(155255);
    }

    /* access modifiers changed from: package-private */
    public boolean isBindingClass(Class<?> cls) {
        AppMethodBeat.i(155256);
        boolean isAssignableFrom = BindingObject.class.isAssignableFrom(cls);
        AppMethodBeat.o(155256);
        return isAssignableFrom;
    }

    /* access modifiers changed from: package-private */
    public void init() {
        AppMethodBeat.i(155257);
        primitives.add(Byte.class);
        primitives.add(Integer.class);
        primitives.add(Long.class);
        primitives.add(Double.class);
        primitives.add(Character.class);
        primitives.add(Float.class);
        primitives.add(Boolean.class);
        primitives.add(Short.class);
        getMemberInfo(this.myClass.getDeclaredMethods(), MemberType.JS_METHOD);
        getMemberInfo(this.myClass.getDeclaredFields(), MemberType.JS_PROPERTY);
        AppMethodBeat.o(155257);
    }

    public static void registerHandlers(ReflectionHelper reflectionHelper, MessageHandler messageHandler, Object obj) {
        AppMethodBeat.i(155258);
        if (reflectionHelper == null || messageHandler == null) {
            AppMethodBeat.o(155258);
            return;
        }
        for (String str : reflectionHelper.getMembers().keySet()) {
            MemberInfo memberInfo = reflectionHelper.getMembers().get(str);
            messageHandler.register(memberInfo.jsName, memberInfo.javaName, memberInfo.type, obj, reflectionHelper);
        }
        AppMethodBeat.o(155258);
    }

    /* access modifiers changed from: package-private */
    public Map<String, MemberInfo> getMembers() {
        return this.members;
    }

    /* access modifiers changed from: package-private */
    public ReflectionHelper getConstructorReflection(String str) {
        AppMethodBeat.i(155259);
        if (!this.constructorReflections.containsKey(str)) {
            AppMethodBeat.o(155259);
            return null;
        }
        ReflectionHelper reflectionHelper = this.constructorReflections.get(str);
        AppMethodBeat.o(155259);
        return reflectionHelper;
    }

    /* access modifiers changed from: package-private */
    public ReflectionHelper getReflectionByBindingClass(String str) {
        AppMethodBeat.i(155260);
        if (!this.bindingClasses.containsKey(str)) {
            AppMethodBeat.o(155260);
            return null;
        }
        ReflectionHelper constructorReflection = getConstructorReflection(this.bindingClasses.get(str));
        AppMethodBeat.o(155260);
        return constructorReflection;
    }

    /* access modifiers changed from: package-private */
    public Boolean hasMethod(String str) {
        AppMethodBeat.i(155261);
        if (!this.members.containsKey(str)) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(155261);
            return bool;
        }
        MemberInfo memberInfo = this.members.get(str);
        Boolean valueOf = Boolean.valueOf(memberInfo.type == MemberType.JS_METHOD || memberInfo.type == MemberType.JS_CONSTRUCTOR);
        AppMethodBeat.o(155261);
        return valueOf;
    }

    /* access modifiers changed from: package-private */
    public Boolean hasProperty(String str) {
        AppMethodBeat.i(155262);
        if (!this.members.containsKey(str)) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(155262);
            return bool;
        }
        Boolean valueOf = Boolean.valueOf(this.members.get(str).type == MemberType.JS_PROPERTY);
        AppMethodBeat.o(155262);
        return valueOf;
    }

    /* access modifiers changed from: package-private */
    public MemberInfo getMemberInfo(String str) {
        AppMethodBeat.i(155263);
        MemberInfo memberInfo = this.members.get(str);
        AppMethodBeat.o(155263);
        return memberInfo;
    }

    /* access modifiers changed from: package-private */
    public Object[] getArgsFromJson(XWalkExternalExtension xWalkExternalExtension, int i2, Method method, JSONArray jSONArray) {
        int i3 = 0;
        AppMethodBeat.i(155264);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        while (i3 < parameterTypes.length) {
            try {
                Class<?> cls = parameterTypes[i3];
                if (!isStatic || !cls.equals(JsContextInfo.class)) {
                    objArr[i3] = jSONArray.get(i3);
                    i3++;
                } else {
                    int i4 = i3 + 1;
                    try {
                        objArr[i3] = new JsContextInfo(i2, xWalkExternalExtension, method.getClass(), Integer.toString(0));
                        i3 = i4;
                    } catch (Exception e2) {
                        i3 = i4;
                    }
                    i3++;
                }
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(155264);
        return objArr;
    }

    public static boolean isSerializable(Object obj) {
        AppMethodBeat.i(155265);
        Class<?> cls = obj.getClass();
        if (cls.isPrimitive() || primitives.contains(cls) || (obj instanceof String) || (obj instanceof Map) || (obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            AppMethodBeat.o(155265);
            return true;
        }
        AppMethodBeat.o(155265);
        return false;
    }

    public static Object toSerializableObject(Object obj) {
        AppMethodBeat.i(155266);
        if (obj.getClass().isArray()) {
            JSONArray jSONArray = new JSONArray();
            Object[] objArr = (Object[]) obj;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                try {
                    jSONArray.put(i2, toSerializableObject(objArr[i2]));
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(155266);
            return jSONArray;
        } else if (isSerializable(obj)) {
            AppMethodBeat.o(155266);
            return obj;
        } else {
            try {
                String str = (String) obj.getClass().getMethod("toJSONString", new Class[0]).invoke(obj, new Object[0]);
                if (str.trim().charAt(0) == '[') {
                    JSONArray jSONArray2 = new JSONArray(str);
                    AppMethodBeat.o(155266);
                    return jSONArray2;
                }
                JSONObject jSONObject = new JSONObject(str);
                AppMethodBeat.o(155266);
                return jSONObject;
            } catch (Exception e3) {
                Log.w(TAG, "No serialization method: \"toJSONString\", or errors happened.");
                try {
                    Class<?> cls = obj.getClass();
                    JSONObject jSONObject2 = new JSONObject();
                    Field[] fields = cls.getFields();
                    for (Field field : fields) {
                        jSONObject2.put(field.getName(), field.get(obj));
                    }
                    AppMethodBeat.o(155266);
                    return jSONObject2;
                } catch (Exception e4) {
                    Log.e(TAG, "Field to serialize object to JSON.");
                    AppMethodBeat.o(155266);
                    return null;
                }
            }
        }
    }

    public static String objToJSON(Object obj) {
        AppMethodBeat.i(155267);
        if (obj == null) {
            AppMethodBeat.o(155267);
            return BuildConfig.COMMAND;
        }
        Object serializableObject = toSerializableObject(obj);
        if (serializableObject == null) {
            AppMethodBeat.o(155267);
            return BuildConfig.COMMAND;
        } else if (serializableObject instanceof String) {
            String quote = JSONObject.quote(serializableObject.toString());
            AppMethodBeat.o(155267);
            return quote;
        } else {
            String obj2 = serializableObject.toString();
            AppMethodBeat.o(155267);
            return obj2;
        }
    }

    /* access modifiers changed from: package-private */
    public Object invokeMethod(XWalkExternalExtension xWalkExternalExtension, int i2, Object obj, String str, JSONArray jSONArray) {
        AppMethodBeat.i(155268);
        if (!hasMethod(str).booleanValue()) {
            NoSuchMethodException noSuchMethodException = new NoSuchMethodException("No such method:".concat(String.valueOf(str)));
            AppMethodBeat.o(155268);
            throw noSuchMethodException;
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Method method = (Method) this.members.get(str).accesser;
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            Object invoke = method.invoke(obj, getArgsFromJson(xWalkExternalExtension, i2, method, jSONArray));
            AppMethodBeat.o(155268);
            return invoke;
        } else {
            InvocationTargetException invocationTargetException = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(str))));
            AppMethodBeat.o(155268);
            throw invocationTargetException;
        }
    }

    /* access modifiers changed from: package-private */
    public Object getProperty(Object obj, String str) {
        AppMethodBeat.i(155269);
        if (!hasProperty(str).booleanValue()) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such property:".concat(String.valueOf(str)));
            AppMethodBeat.o(155269);
            throw noSuchFieldException;
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Field field = (Field) this.members.get(str).accesser;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            AppMethodBeat.o(155269);
            return obj2;
        } else {
            InvocationTargetException invocationTargetException = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(str))));
            AppMethodBeat.o(155269);
            throw invocationTargetException;
        }
    }

    /* access modifiers changed from: package-private */
    public void setProperty(Object obj, String str, Object obj2) {
        AppMethodBeat.i(155270);
        if (!hasProperty(str).booleanValue()) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such property:".concat(String.valueOf(str)));
            AppMethodBeat.o(155270);
            throw noSuchFieldException;
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Field field = (Field) this.members.get(str).accesser;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            field.set(obj, obj2);
            AppMethodBeat.o(155270);
        } else {
            InvocationTargetException invocationTargetException = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(str))));
            AppMethodBeat.o(155270);
            throw invocationTargetException;
        }
    }

    /* access modifiers changed from: package-private */
    public String[] getEventList() {
        return this.eventList;
    }

    /* access modifiers changed from: package-private */
    public MemberInfo getEntryPoint() {
        return this.entryPoint;
    }

    /* access modifiers changed from: package-private */
    public boolean isEventSupported(String str) {
        AppMethodBeat.i(155271);
        if (this.eventList == null) {
            AppMethodBeat.o(155271);
            return false;
        }
        for (int i2 = 0; i2 < this.eventList.length; i2++) {
            if (this.eventList[i2].equals(str)) {
                AppMethodBeat.o(155271);
                return true;
            }
        }
        AppMethodBeat.o(155271);
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isInstance(Object obj) {
        AppMethodBeat.i(155272);
        boolean isInstance = this.myClass.isInstance(obj);
        AppMethodBeat.o(155272);
        return isInstance;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        if (r7.equals("invokeNative") != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object handleMessage(org.xwalk.core.extension.MessageInfo r11, java.lang.Object r12) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.extension.ReflectionHelper.handleMessage(org.xwalk.core.extension.MessageInfo, java.lang.Object):java.lang.Object");
    }
}
