<template>
  <div class="navbar">
    <div class="left-menu">
      <img src="/app.png" style="height: 35px; width: 35px;margin-bottom: 5px; margin-left: 20px;">
      <h1 class="tip">Internet Gravepool</h1>
    </div>
    <div class="right-menu">
      <div class="search-container">
        <el-input
          v-model="searchQuery"
          placeholder="搜索..."
          style="width: 200px; vertical-align: middle;"
          clearable
          @keyup.enter="handleSearch"
        >
          <i slot="prefix" class="el-input__icon el-icon-search"></i>
        </el-input>
      </div>
      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img src="/user.png" class="user-avatar">
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/user/profile">
            <el-dropdown-item>个人中心</el-dropdown-item>
          </router-link>
          <el-dropdown-item divided @click.native="logout">
            <span>退出登录</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Search from '@/components/HeaderSearch'

export default {
  components: {
    Search,
  },
  data() {
    return {
      searchQuery: '' // 搜索输入的值
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'device'
    ]),
    setting: {
      get() {
        return this.$store.state.settings.showSettings
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'showSettings',
          value: val
        })
      }
    }
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch('app/toggleSideBar')
    },
    async logout() {
      this.$confirm('确定注销并退出系统吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$store.dispatch('LogOut').then(() => {
          location.href = '/index';
        })
      })
    },
    handleSearch() {
      // 这里可以添加搜索逻辑，例如跳转到搜索页面或触发搜索事件
      console.log('搜索内容:', this.searchQuery)
      // 示例：跳转到搜索结果页面
      if (this.searchQuery) {
        this.$router.push({ path: `/search?q=${this.searchQuery}` })
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .tip{
    font-size: 25px;
    margin-left: 15px;
    font-weight: 700;
    margin-top: 10px;
  }

  .left-menu {
    float: left;
    margin-top: 0px;
    display: flex;
    align-items: center;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;
    display: flex;
    align-items: center;

    &:focus {
      outline: none;
    }

    .search-container {
      margin-right: 10px;
      
      ::v-deep .el-input__inner { /* 使用 ::v-deep 兼容 Vue 2 */
        border-radius: 20px;
        padding-left: 30px;
      }
    }

    .right-menu-item {
      display: inline-block;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background .3s;

        &:hover {
          background: rgba(0, 0, 0, .025)
        }
      }
    }

    .avatar-container {
      margin-right: 15px;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -10px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
}
</style>