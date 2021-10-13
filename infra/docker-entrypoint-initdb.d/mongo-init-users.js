print('START USERS DB INIT #################################################################');

db.createUser(
    {
        user: "pixel",
        pwd: "pixel1234",
        roles: [
            {
                role: "readWrite",
                db: "pixel-users"
            }
        ]
    }
)

db.getSiblingDB('pixel-users');
db.createCollection('users');

db.users.insertMany([
    {
        username: 'admin',
        password: 'bI0DxKGYjwdwWM2UU8sHBQ1UOyyQjvKDnowh0aLJhkY=',
        display: 'Test Admin'
    }
]);

print('END USERS DB INIT #################################################################');