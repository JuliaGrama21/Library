var app = angular.module("authorsApp", []);

app.controller("authorsCtrl", function ($scope, $sce, $http) {
    $scope.authors = [];
    $http.get('/getAuthors').then(function (response) {
        $scope.authors = response.data;
    });

    $scope.editAuthor = function (author) {
        author.edit = !author.edit;
        if (!author.edit) {
            $http.post('/updateAuthor', JSON.stringify(author)).then(function (response) {
                author.id = response.data.id;
            })
        }
    };

    $scope.deleteAuthor = function (author) {
        var index = $scope.authors.indexOf(author);
        if (index !== -1) {
            if (author.id !== -1) {
                $http.post('/deleteAuthor', author.id).then(function (response) {
                    $scope.authors.splice(index, 1);
                    console.log(response);
                })
            } else {
                $scope.authors.splice(index, 1);
            }
        }
    };

    $scope.addAuthor = function () {
        $scope.authors.push({
            id: -1,
            firstName: '',
            lastName: '',
            booksName: [],
            edit: true
        })
    };

    $scope.wrapBooksNames = function (booksNames) {
        var array = [];

        booksNames.forEach(function (bookName) {
            array.push("<a href='/books'> " + bookName + "</a>");
        });

        return $sce.trustAsHtml(array.join(', '));
    };

});