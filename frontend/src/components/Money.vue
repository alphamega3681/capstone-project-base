<template>


    <v-card outlined>
        <v-card-title>
            Money
        </v-card-title>

        <v-card-text>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="Currency" v-model="value.currency" :editMode="editMode"/>

        </v-card-text>

        <v-card-actions v-if="inList">
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="add"
                    v-else
            >
                Add
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

    export default {
        name: 'Money',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!this.value) {
                this.$emit('input', {});
                this.newValue = {
                    'amount': '',
                    'currency': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('amount' in this.value)) {
                    this.value.amount = null;
                }
                if(!('currency' in this.value)) {
                    this.value.currency = null;
                }
            }
            
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

