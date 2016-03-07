#include "cn_aki_demo_jni_JniUtils.h"

JNIEXPORT jstring JNICALL Java_cn_aki_demo_jni_JniUtils_hello
  (JNIEnv * env, jobject obj){
    char* word="hello from c";
    jstring jstr = (*env)->NewStringUTF(env, word);
    return jstr;
 }