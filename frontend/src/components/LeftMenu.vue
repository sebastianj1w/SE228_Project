<template>
    <Card :padding="0">
        <Menu :theme="theme3" active-name="1" style="width: auto; height: 398px;">
            <MenuGroup title="内容分类">
                <MenuItem name="1">
                    <Icon type="md-document"/>
                    文学著作
                </MenuItem>
                <MenuItem name="2">
                    <Icon type="md-document"/>
                    科学技术
                </MenuItem>
                <MenuItem name="3">
                    <Icon type="md-document"/>
                    教材教辅
                </MenuItem>
                <MenuItem name="4">
                    <Icon type="md-document"/>
                    报纸期刊
                </MenuItem>
                <MenuItem name="5">
                    <Icon type="md-document"/>
                    其他类别
                </MenuItem>
            </MenuGroup>
        </Menu>
    </Card>
</template>
<script>
    export default {
        data() {
            return {
                theme3: 'light'
            }
        }
    }
</script>