import React from "react";

const App = (props) => {
    return (
        <div className="container">
            <div className="row">
                <div className="row">
                    <div className="col-md-12">
                        <h1>Example - Framework List</h1>
                    </div>
                </div>
                {props.children}
            </div>
        </div>
    );
};

export default App;