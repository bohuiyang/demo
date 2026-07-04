#!/bin/bash
#
# M0 Git 冲突场景 — 自动搭建脚本
#
# 这个脚本在 main 分支上模拟"同事张三先提交了代码"，
# 然后你的 feature 分支 merge main 时就会出现冲突。
#
# 用法（AI 教练操作）：
#   cd training-project
#   bash conflict-scenarios/setup-conflict.sh
#

set -e

echo "===== Git 冲突场景搭建 ====="
echo ""

# 1. 确认当前在 main 分支
BRANCH=$(git branch --show-current)
if [ "$BRANCH" != "main" ]; then
    echo "❌ 当前不在 main 分支，当前在: $BRANCH"
    echo "   请先 git checkout main"
    exit 1
fi

# 2. 备份原始文件
echo "📦 备份原始 UserServiceImpl.java ..."
cp src/main/java/com/example/demo/service/impl/UserServiceImpl.java \
   conflict-scenarios/original-backup.java

# 3. 替换为张三的版本（模拟张三已经合并到 main）
echo "👤 模拟张三的修改已合并到 main ..."
cp conflict-scenarios/zhangsan-bugfix.java \
   src/main/java/com/example/demo/service/impl/UserServiceImpl.java

# 4. 提交
echo "📝 张三提交 ..."
git add src/main/java/com/example/demo/service/impl/UserServiceImpl.java
git commit -m "fix: 张三 — 用户昵称为 null 时返回空字符串，同时 email 加 null 处理" || true

echo ""
echo "===== ✅ 冲突场景搭建完成 ====="
echo ""
echo "现在 main 分支上已经包含了张三的改动。"
echo "学员在 feature/user-nickname-fix 分支上的改动会和 main 冲突。"
echo ""
echo "恢复方法："
echo "  cp conflict-scenarios/original-backup.java \\"
echo "     src/main/java/com/example/demo/service/impl/UserServiceImpl.java"
echo "  git add . && git commit -m 'revert: 恢复原始版本'"
