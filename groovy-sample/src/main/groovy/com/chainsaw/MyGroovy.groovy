package com.chainsaw

/**
 * Created by richard on 9/4/16 11:05 AM.
 */

def getTime(Date date) {
    date.getTime();
}

def getDate(long time) {
    new Date(time);
}