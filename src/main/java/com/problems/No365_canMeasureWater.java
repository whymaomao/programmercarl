package com.problems;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: true
 * 解释：
 * 按照以下步骤操作，以达到总共 4 升水：
 * 1. 装满 5 升的水壶(0, 5)。
 * 2. 把 5 升的水壶倒进 3 升的水壶，留下 2 升(3, 2)。
 * 3. 倒空 3 升的水壶(0, 2)。
 * 4. 把 2 升水从 5 升的水壶转移到 3 升的水壶(2, 0)。
 * 5. 再次加满 5 升的水壶(2, 5)。
 * 6. 从 5 升的水壶向 3 升的水壶倒水直到 3 升的水壶倒满。5 升的水壶里留下了 4 升水(3, 4)。
 * 7. 倒空 3 升的水壶。现在，5 升的水壶里正好有 4 升水(0, 4)。
 * 参考：来自著名的 "Die Hard"
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class No365_canMeasureWater {
    public boolean canMeasureWater(int x, int y, int target) {
        return true;
    }
}
