package com.example.xposedtest;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HookUtil implements IXposedHookLoadPackage{

	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable{
        HookMethod(TelephonyManager.class, "getDeviceId", "00000000000000");
    }

    private void HookMethod(final Class clazz, final String method, final String result){
        try{
            XposedHelpers.findAndHookMethod(clazz, method, new Object[] { new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(result);
                }
            } });
        } catch (Throwable e){
            e.printStackTrace();
        }
    }
}
