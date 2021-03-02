package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import org.xwalk.core.extension.ReflectionHelper;

public class JsStubGenerator {
    public static final String MSG_TO_CLASS = "postMessageToClass";
    public static final String MSG_TO_EXTENSION = "postMessageToExtension";
    public static final String MSG_TO_OBJECT = "postMessageToObject";
    public static String TAG = "JsStubGenerator";
    String jsHeader = "var v8tools = requireNative(\"v8tools\");\nvar jsStubModule = requireNative(\"jsStub\");\njsStubModule.init(extension, v8tools);\nvar jsStub = jsStubModule.jsStub;\nvar helper = jsStub.createRootStub(exports);\n";
    ReflectionHelper reflection;

    JsStubGenerator(ReflectionHelper reflectionHelper) {
        this.reflection = reflectionHelper;
    }

    /* access modifiers changed from: package-private */
    public String generate() {
        String str;
        AppMethodBeat.i(155227);
        String str2 = "";
        ReflectionHelper.MemberInfo entryPoint = this.reflection.getEntryPoint();
        if (entryPoint != null) {
            str2 = generateEntryPoint(entryPoint);
        }
        if (str2.length() <= 0) {
            str2 = this.jsHeader;
        }
        if (this.reflection.getEventList() != null) {
            str2 = str2 + generateEventTarget(this.reflection);
        }
        Map<String, ReflectionHelper.MemberInfo> members = this.reflection.getMembers();
        String str3 = str2;
        for (String str4 : members.keySet()) {
            ReflectionHelper.MemberInfo memberInfo = members.get(str4);
            if (!memberInfo.isEntryPoint) {
                switch (memberInfo.type) {
                    case JS_PROPERTY:
                        str3 = str3 + generateProperty(MSG_TO_EXTENSION, memberInfo);
                        break;
                    case JS_METHOD:
                        str3 = str3 + generateMethod(MSG_TO_EXTENSION, memberInfo, true);
                        break;
                    case JS_CONSTRUCTOR:
                        str = str3 + generateConstructor(memberInfo, true);
                        str3 = str;
                        break;
                    default:
                        str = str3;
                        str3 = str;
                        break;
                }
            }
        }
        String str5 = str3 + "\n";
        AppMethodBeat.o(155227);
        return str5;
    }

    /* access modifiers changed from: package-private */
    public String generateEntryPoint(ReflectionHelper.MemberInfo memberInfo) {
        AppMethodBeat.i(155228);
        if (memberInfo.type == ReflectionHelper.MemberType.JS_PROPERTY) {
            String simpleName = ((Field) memberInfo.accesser).getType().getSimpleName();
            String str = this.jsHeader + String.format("%s(exports, helper);\n", getPrototypeName(simpleName));
            AppMethodBeat.o(155228);
            return str;
        } else if (memberInfo.type == ReflectionHelper.MemberType.JS_METHOD) {
            String format = String.format("exports = %s;\n %s\n %s", getInternalName(memberInfo.jsName), this.jsHeader, generateMethod(MSG_TO_EXTENSION, memberInfo, false));
            AppMethodBeat.o(155228);
            return format;
        } else if (memberInfo.type == ReflectionHelper.MemberType.JS_CONSTRUCTOR) {
            String format2 = String.format("exports = %s;\n %s\n %s", memberInfo.jsName, this.jsHeader, generateConstructor(memberInfo, false));
            AppMethodBeat.o(155228);
            return format2;
        } else {
            AppMethodBeat.o(155228);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public String[] classGenerator(ReflectionHelper reflectionHelper) {
        String generateMethod;
        AppMethodBeat.i(155229);
        String str = "";
        String str2 = "";
        if (reflectionHelper.getEventList() != null) {
            String generateEventTarget = generateEventTarget(reflectionHelper);
            str = str + generateEventTarget;
            str2 = str2 + generateEventTarget;
        }
        Map<String, ReflectionHelper.MemberInfo> members = reflectionHelper.getMembers();
        String str3 = str2;
        String str4 = str;
        for (String str5 : members.keySet()) {
            ReflectionHelper.MemberInfo memberInfo = members.get(str5);
            String str6 = memberInfo.isStatic ? MSG_TO_CLASS : MSG_TO_OBJECT;
            switch (memberInfo.type) {
                case JS_PROPERTY:
                    generateMethod = generateProperty(str6, memberInfo);
                    break;
                case JS_METHOD:
                    generateMethod = generateMethod(str6, memberInfo, true);
                    break;
                default:
                    generateMethod = "";
                    break;
            }
            if (memberInfo.isStatic) {
                str3 = str3 + generateMethod;
            } else {
                str4 = str4 + generateMethod;
            }
        }
        String[] strArr = {str4, str3};
        AppMethodBeat.o(155229);
        return strArr;
    }

    /* access modifiers changed from: package-private */
    public String destroyBindingObject(ReflectionHelper reflectionHelper) {
        AppMethodBeat.i(155230);
        String str = "exports.destroy = function() {\n";
        Iterator<String> it = reflectionHelper.getMembers().keySet().iterator();
        while (it.hasNext()) {
            str = str + "delete exports[\"" + it.next() + "\"];\n";
        }
        String str2 = (((str + "helper.destroy();\n") + "delete exports[\"__stubHelper\"];\n") + "delete exports[\"destroy\"];\n") + "};";
        AppMethodBeat.o(155230);
        return str2;
    }

    /* access modifiers changed from: package-private */
    public String generateEventTarget(ReflectionHelper reflectionHelper) {
        AppMethodBeat.i(155231);
        String[] eventList = reflectionHelper.getEventList();
        if (eventList == null || eventList.length == 0) {
            AppMethodBeat.o(155231);
            return "";
        }
        String str = "jsStub.makeEventTarget(exports);\n";
        for (int i2 = 0; i2 < eventList.length; i2++) {
            str = str + "helper.addEvent(\"" + eventList[i2] + "\");\n";
        }
        AppMethodBeat.o(155231);
        return str;
    }

    /* access modifiers changed from: package-private */
    public String generateProperty(String str, ReflectionHelper.MemberInfo memberInfo) {
        AppMethodBeat.i(155232);
        String format = String.format("jsStub.defineProperty(\"%s\", exports, \"%s\", %b);\n", str, memberInfo.jsName, Boolean.valueOf(memberInfo.isWritable));
        AppMethodBeat.o(155232);
        return format;
    }

    /* access modifiers changed from: package-private */
    public String generatePromiseMethod(String str, ReflectionHelper.MemberInfo memberInfo) {
        AppMethodBeat.i(155233);
        String format = String.format("jsStub.addMethodWithPromise(\"%s\", exports, \"%s\", %s, %s);\n", str, memberInfo.jsName, memberInfo.wrapArgs.length() > 0 ? memberInfo.wrapArgs : BuildConfig.COMMAND, memberInfo.wrapReturns.length() > 0 ? memberInfo.wrapReturns : BuildConfig.COMMAND);
        AppMethodBeat.o(155233);
        return format;
    }

    /* access modifiers changed from: package-private */
    public String getArgString(Method method, boolean z) {
        AppMethodBeat.i(155234);
        if (method == null) {
            AppMethodBeat.o(155234);
            return "";
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        method.getParameterAnnotations();
        String str = "";
        int length = z ? parameterTypes.length - 1 : parameterTypes.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = "arg" + i2 + "_" + parameterTypes[i2].getSimpleName();
            if (str.length() > 0) {
                str = str + ", ";
            }
            str = str + str2;
        }
        AppMethodBeat.o(155234);
        return str;
    }

    /* access modifiers changed from: package-private */
    public String generateMethod(String str, ReflectionHelper.MemberInfo memberInfo, boolean z) {
        AppMethodBeat.i(155235);
        if (memberInfo.withPromise) {
            String generatePromiseMethod = generatePromiseMethod(str, memberInfo);
            AppMethodBeat.o(155235);
            return generatePromiseMethod;
        }
        String str2 = memberInfo.jsName;
        Method method = (Method) memberInfo.accesser;
        String internalName = getInternalName(str2);
        method.getParameterAnnotations();
        String argString = getArgString(method, memberInfo.withPromise);
        boolean z2 = !method.getReturnType().equals(Void.TYPE);
        String str3 = String.format("function %s(%s) {\n" + (z2 ? "  return " : "  ") + "helper.invokeNative(\"%s\", \"%s\", [%s], %b);\n};\n", internalName, argString, str, str2, argString, Boolean.valueOf(z2)) + (z ? String.format("exports[\"%s\"] = %s;\n", str2, internalName) : "");
        AppMethodBeat.o(155235);
        return str3;
    }

    /* access modifiers changed from: package-private */
    public String getInternalName(String str) {
        AppMethodBeat.i(155236);
        String concat = "__".concat(String.valueOf(str));
        AppMethodBeat.o(155236);
        return concat;
    }

    /* access modifiers changed from: package-private */
    public String getPrototypeName(String str) {
        AppMethodBeat.i(155237);
        String str2 = "__" + str + "_prototype";
        AppMethodBeat.o(155237);
        return str2;
    }

    /* access modifiers changed from: package-private */
    public String generateConstructor(ReflectionHelper.MemberInfo memberInfo, boolean z) {
        String str;
        AppMethodBeat.i(155238);
        String str2 = memberInfo.jsName;
        String prototypeName = getPrototypeName(str2);
        String argString = getArgString((Method) memberInfo.accesser, false);
        ReflectionHelper constructorReflection = this.reflection.getConstructorReflection(str2);
        String[] classGenerator = classGenerator(constructorReflection);
        String format = String.format("function %s(exports, helper){\n%s\n%s\n}\n", prototypeName, classGenerator[0], destroyBindingObject(constructorReflection));
        String format2 = String.format("function %s(%s) {\nvar newObject = this;\nvar objectId =\nNumber(helper.invokeNative(\"%s\", \"+%s\", [%s], true));\nif (!objectId) throw \"Error to create instance for constructor:%s.\";\nvar objectHelper = jsStub.getHelper(newObject, helper);\nobjectHelper.objectId = objectId;\nobjectHelper.constructorJsName = \"%s\";\nobjectHelper.registerLifecycleTracker();%s(newObject, objectHelper);\nhelper.addBindingObject(objectId, newObject);}\nhelper.constructors[\"%s\"] = %s;\n", str2, argString, MSG_TO_EXTENSION, str2, argString, str2, str2, prototypeName, str2, str2);
        String format3 = String.format("(function(exports, helper){\n  helper.constructorJsName = \"%s\";\n%s\n})(%s, jsStub.getHelper(%s, helper));\n", str2, classGenerator[1], str2, str2);
        if (z) {
            str = String.format("exports[\"%s\"] = %s;\n", str2, str2);
        } else {
            str = "";
        }
        String str3 = format + format2 + format3 + str;
        AppMethodBeat.o(155238);
        return str3;
    }
}
