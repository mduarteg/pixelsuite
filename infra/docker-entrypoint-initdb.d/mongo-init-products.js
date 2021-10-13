print('START PRODUCTS DB INIT #################################################################');

db.createUser(
    {
        user: "pixel",
        pwd: "pixel1234",
        roles: [
            {
                role: "readWrite",
                db: "pixel-products"
            }
        ]
    }
)

print('END PRODUCTS DB INIT #################################################################');