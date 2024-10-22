package com.problems;


public class No8_atoi {

    public enum Event {
        START(0),
        SIGNED(1),
        NUM(2),
        OTHER(3);

        private int index;

        public int getIndex(){
            return this.index;
        }

        private Event(int index) {
            this.index = index;
        }


    }

    public enum STATE {
        START(0),
        SIGNED(1),
        NUM(2),
        END(3);
        private int index;

        public int getIndex(){
            return this.index;
        }

        private STATE(int index) {
            this.index = index;
        }
    }


    private static final STATE[][] transitionTable = {
            { STATE.START, STATE.SIGNED, STATE.NUM, STATE.END},
            { STATE.END, STATE.END, STATE.NUM, STATE.END},
            { STATE.NUM, STATE.END, STATE.NUM, STATE.END},
            { STATE.END, STATE.END, STATE.END, STATE.END}
    };

    public int getEvent(char character) {
        if(character == ' ') {
            return Event.START.index;
        } else if(Character.isDigit(character)) {
            return Event.NUM.index;
        } else if(character == '+' || character == '-') {
            return Event.SIGNED.index;
        } else {
            return Event.OTHER.index;
        }
    }

    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
     *
     * 函数 myAtoi(string s) 的算法如下：
     *
     * 空格：读入字符串并丢弃无用的前导空格（" "）
     * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
     * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
     * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
     * 返回整数作为最终结果。
     * @param s
     * @return
     */

    public int myAtoi(String s) {
        STATE currentState = STATE.START;
        long result = 0;
        boolean isNegative = false;
        for(int i = 0; i < s.length(); i ++) {
            char temp = s.charAt(i);
            int eventIndex = getEvent(temp);

            currentState = transitionTable[currentState.getIndex()][eventIndex];
            if(currentState.equals(STATE.END)) {
                break;
            } else if(currentState.equals(STATE.NUM)) {
                result = result * 10 + temp - '0';
                //System.out.println(result);
                result = isNegative ? Math.min(result, -(long)Integer.MIN_VALUE) : Math.min(result, (long) Integer.MAX_VALUE);
            } else if(currentState.equals(STATE.SIGNED)) {
                if(temp == '-'){
                    isNegative = true;
                }
            }
        }
        return (int) (isNegative ? -result : result);
    }
}
