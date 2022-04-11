#!/bin/bash
# CSE237 EasyMeal Project

cd src/ || return
javac menu/MenuItem.java cart/UserCart.java tip/TipFunction.java main/MenuClass.java main/MainMethod.java
java main/MainMethod