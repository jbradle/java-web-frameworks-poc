import React from 'react';
import Time from 'react-time';

const FrameworkEdit = (props) => {

    let framework = props.framework;

    let categories = props.categories.map(category =>
        <option key={category.id} value={category.id}>{category.name}</option>
    );

    return (
        <div className="col-md-12">
            <div className="well">
                <h4>Edit Framework</h4>

                <form name="addFramework">
                    <input type="hidden" value={framework.id}/>

                    <div className="control-group form-group">
                        <div className="controls">
                            <label>Name:</label>
                            <input type="text" className="form-control" value={framework.name}/>

                            <p className="help-block"/>
                        </div>
                    </div>
                    <div className="control-group form-group">
                        <div className="controls">
                            <label>Description:</label>
                            <textarea className="form-control" rows="3" value={framework.description}/>

                            <div className="help-block"></div>
                        </div>
                    </div>
                    <div className="control-group form-group">
                        <div className="controls">
                            <label>Documentation Link:</label>
                            <input type="text" className="form-control" value={framework.documentationLink}/>

                            <div className="help-block"></div>
                        </div>
                    </div>
                    <div className="control-group form-group">
                        <label>Category:</label>
                        <select className="form-control">
                            {categories}
                        </select>
                    </div>
                    <div id="success"></div>
                    <button type="submit" className="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    );
};

FrameworkEdit.propTypes = {
    framework: React.PropTypes.object,
    categories: React.PropTypes.array,
    saveFce: React.PropTypes.fce
};

export default FrameworkEdit;